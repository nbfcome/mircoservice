package com.mzjf.logs;

import com.google.common.collect.Ordering;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;
import scala.Tuple4;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class LogAnalyzerWindowed implements Serializable {
    /**
       * 
       */
    private static final long serialVersionUID = 5999294813908439123L;
    private LogStatistics logStatistics;

    @SuppressWarnings("unused")
    public void processAccessLogs(String outDir, JavaDStream<ApacheAccessLog> accessLogsDStream) {
        JavaDStream<ApacheAccessLog> windowDStream = accessLogsDStream.window(
                Flags.getInstance().getWindowLength(),
                Flags.getInstance().getSlideInterval());
        JavaDStream<String> ip = accessLogsDStream.map(
                new Function<ApacheAccessLog, String>() {
                    /**
                     * 
                     */
                    private static final long serialVersionUID = -3085218002338570650L;

                    public String call(ApacheAccessLog entry) {
                        return entry.getIpAddress();
                    }
                });
        // reduceByWindow
        JavaDStream<Long> requestCountRBW = accessLogsDStream.map(
                new Function<ApacheAccessLog, Long>() {
                    /**
                     * 
                     */
                    private static final long serialVersionUID = -2165798048199461539L;

                    public Long call(ApacheAccessLog entry) {
                        return 1L;
                    }
                }).reduceByWindow(new Function2<Long, Long, Long>() {
            /**
             * 
             */
            private static final long serialVersionUID = 3748642530790444868L;

            public Long call(Long v1, Long v2) {
                return v1 + v2;
            }
        }, new Function2<Long, Long, Long>() {
            /**
                 * 
                 */
            private static final long serialVersionUID = -2620922580010342716L;

            public Long call(Long v1, Long v2) {
                return v1 - v2;
            }
        }, Flags.getInstance().getWindowLength(), Flags.getInstance().getSlideInterval());
        requestCountRBW.print();
        // reducebykeyandwindow
        JavaPairDStream<String, Long> ipAddressPairDStream = accessLogsDStream.mapToPair(
                new PairFunction<ApacheAccessLog, String, Long>() {
                    /**
                     * 
                     */
                    private static final long serialVersionUID = -5486641480199475312L;

                    @SuppressWarnings({ "unchecked", "rawtypes" })
                    public Tuple2<String, Long> call(ApacheAccessLog entry) {
                        return new Tuple2(entry.getIpAddress(), 1L);
                    }
                });
        JavaPairDStream<String, Long> ipCountDStream = ipAddressPairDStream.reduceByKeyAndWindow(
                // Adding elements in the new slice
                new Function2<Long, Long, Long>() {
                    /**
                     * 
                     */
                    private static final long serialVersionUID = -275994997247524097L;

                    public Long call(Long v1, Long v2) {
                        return v1 + v2;
                    }
                },
                // Removing elements from the oldest slice
                new Function2<Long, Long, Long>() {
                    /**
                     * 
                     */
                    private static final long serialVersionUID = -3371036340874454497L;

                    public Long call(Long v1, Long v2) {
                        return v1 - v2;
                    }
                },
                Flags.getInstance().getWindowLength(),
                Flags.getInstance().getSlideInterval());
        ipCountDStream.print();
        // Use countByWindow
        JavaDStream<Long> requestCount = accessLogsDStream.countByWindow(
                Flags.getInstance().getWindowLength(), Flags.getInstance().getSlideInterval());
        JavaPairDStream<String, Long> ipAddressRequestCount = ip.countByValueAndWindow(
                Flags.getInstance().getWindowLength(), Flags.getInstance().getSlideInterval());
        requestCount.print();
        ipAddressRequestCount.print();

        // use a transform for the response code count
        JavaPairDStream<Integer, Long> responseCodeCountTransform = accessLogsDStream
                .transformToPair(
                new Function<JavaRDD<ApacheAccessLog>, JavaPairRDD<Integer, Long>>() {
                    /**
                     * 
                     */
                    private static final long serialVersionUID = 7635954619339911180L;

                    public JavaPairRDD<Integer, Long> call(JavaRDD<ApacheAccessLog> logs) {
                        return Functions.responseCodeCount(logs);
                    }
                });
        windowDStream.foreachRDD(new Function<JavaRDD<ApacheAccessLog>, Void>() {
            /**
             * 
             */
            private static final long serialVersionUID = -241932926623972054L;

            @SuppressWarnings("unchecked")
            public Void call(JavaRDD<ApacheAccessLog> accessLogs) {
                Tuple4<Long, Long, Long, Long> contentSizeStats =
                        Functions.contentSizeStats(accessLogs);

                List<Tuple2<Integer, Long>> responseCodeToCount =
                        Functions.responseCodeCount(accessLogs)
                                .take(100);

                JavaPairRDD<String, Long> ipAddressCounts =
                        Functions.ipAddressCount(accessLogs);
                List<String> ip = Functions.filterIPAddress(ipAddressCounts)
                        .take(100);

                Object ordering = Ordering.natural();
                Comparator<Long> cmp = (Comparator<Long>) ordering;
                List<Tuple2<String, Long>> topEndpoints =
                        Functions.endpointCount(accessLogs)
                                .top(10, new Functions.ValueComparator<String, Long>(cmp));

                logStatistics = new LogStatistics(contentSizeStats, responseCodeToCount,
                        ip, topEndpoints);
                return null;
            }
        });
    }

    public LogStatistics getLogStatistics() {
        return logStatistics;
    }
}
