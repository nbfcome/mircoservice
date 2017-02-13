package com.mzjf.logs;

import com.google.common.collect.Ordering;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;
import scala.Tuple4;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;

public class LogAnalyzerTotal implements Serializable {
    /**
       * 
       */
    private static final long serialVersionUID = -1085857700254984003L;
    // These static variables stores the running content size values.
    private static final AtomicLong runningCount = new AtomicLong(0);
    private static final AtomicLong runningSum = new AtomicLong(0);
    private static final AtomicLong runningMin = new AtomicLong(Long.MAX_VALUE);
    private static final AtomicLong runningMax = new AtomicLong(Long.MIN_VALUE);
    private static List<Tuple2<Integer, Long>> currentResponseCodeCounts = null;
    private static List<String> currentIPAddresses = null;
    private static List<Tuple2<String, Long>> currentTopEndpoints = null;

    @SuppressWarnings("unchecked")
    public void processAccessLogs(String outDir, JavaDStream<ApacheAccessLog> accessLogsDStream) {
        // Calculate statistics based on the content size, and update the static variables to track this.
        accessLogsDStream.foreachRDD(new Function<JavaRDD<ApacheAccessLog>, Void>() {
            /**
             * 
             */
            private static final long serialVersionUID = -5515971095100691346L;

            public Void call(JavaRDD<ApacheAccessLog> accessLogs) {
                Tuple4<Long, Long, Long, Long> stats =
                        Functions.contentSizeStats(accessLogs);
                if (stats != null) {
                    runningCount.getAndAdd(stats._1());
                    runningSum.getAndAdd(stats._2());
                    runningMin.set(Math.min(runningMin.get(), stats._3()));
                    runningMax.set(Math.max(runningMax.get(), stats._4()));
                }
                return null;
            }
        }
                );

        // A DStream of Resonse Code Counts;
        JavaPairDStream<Integer, Long> responseCodeCountDStream = accessLogsDStream
                .transformToPair(
                        new Function<JavaRDD<ApacheAccessLog>, JavaPairRDD<Integer, Long>>() {
                            /**
                             * 
                             */
                            private static final long serialVersionUID = 1300529813318915304L;

                            public JavaPairRDD<Integer, Long> call(JavaRDD<ApacheAccessLog> rdd) {
                                return Functions.responseCodeCount(rdd);
                            }
                        })
                .updateStateByKey(new Functions.ComputeRunningSum());
        responseCodeCountDStream.foreachRDD(new Function<JavaPairRDD<Integer, Long>, Void>() {
            /**
             * 
             */
            private static final long serialVersionUID = 8732455241838691984L;

            public Void call(JavaPairRDD<Integer, Long> rdd) {
                currentResponseCodeCounts = rdd.take(100);
                return null;
            }
        });

        // A DStream of ipAddressCounts.
        JavaPairDStream<String, Long> ipRawDStream = accessLogsDStream.transformToPair(
                new Function<JavaRDD<ApacheAccessLog>, JavaPairRDD<String, Long>>() {
                    /**
                       * 
                       */
                    private static final long serialVersionUID = 2564753389030419529L;

                    public JavaPairRDD<String, Long> call(JavaRDD<ApacheAccessLog> rdd) {
                        return Functions.ipAddressCount(rdd);
                    }
                });

        JavaPairDStream<String, Long> ipCumDStream = ipRawDStream.updateStateByKey(
                new Functions.ComputeRunningSum());

        // A DStream of ipAddressCounts without transform
        JavaPairDStream<String, Long> ipDStream = accessLogsDStream
                .mapToPair(new Functions.IpTuple());
        JavaPairDStream<String, Long> ipCountsDStream = ipDStream
                .reduceByKey(new Functions.LongSumReducer());
        // and joining it with the transfer amount
        JavaPairDStream<String, Long> ipBytesDStream = accessLogsDStream
                .mapToPair(new Functions.IpContentTuple());
        JavaPairDStream<String, Long> ipBytesSumDStream = ipBytesDStream
                .reduceByKey(new Functions.LongSumReducer());
        @SuppressWarnings("unused")
        JavaPairDStream<String, Tuple2<Long, Long>> ipBytesRequestCountDStream = ipBytesSumDStream
                .join(ipCountsDStream);

        // Save our dstream of ip address request counts
        JavaPairDStream<Text, LongWritable> writableDStream = ipDStream.mapToPair(
                new PairFunction<Tuple2<String, Long>, Text, LongWritable>() {
                    /**
                     * 
                     */
                    private static final long serialVersionUID = -7667712553199262005L;

                    @SuppressWarnings({ "rawtypes" })
                    public Tuple2<Text, LongWritable> call(Tuple2<String, Long> e) {
                        return new Tuple2(new Text(e._1()), new LongWritable(e._2()));
                    }
                });
        class OutFormat extends SequenceFileOutputFormat<Text, LongWritable> {
        };
        writableDStream.saveAsHadoopFiles(outDir, "pandas",
                Text.class, LongWritable.class,
                OutFormat.class);

        // All ips more than 10
        JavaDStream<String> ipAddressDStream = ipCumDStream.transform(
                new Function<JavaPairRDD<String, Long>, JavaRDD<String>>() {
                    /**
                     * 
                     */
                    private static final long serialVersionUID = -1787338832637641664L;

                    public JavaRDD<String> call(JavaPairRDD<String, Long> rdd) {
                        return Functions.filterIPAddress(rdd);
                    }
                });

        ipAddressDStream.foreachRDD(new Function<JavaRDD<String>, Void>() {
            /**
             * 
             */
            private static final long serialVersionUID = -75382374709304803L;

            public Void call(JavaRDD<String> rdd) {
                @SuppressWarnings("unused")
                List<String> currentIPAddresses = rdd.take(100);
                return null;
            }
        });

        // A DStream of endpoint to count.
        JavaPairDStream<String, Long> endpointCountsDStream = accessLogsDStream.transformToPair(
                new Function<JavaRDD<ApacheAccessLog>, JavaPairRDD<String, Long>>() {
                    /**
                     * 
                     */
                    private static final long serialVersionUID = -3506783524764582875L;

                    public JavaPairRDD<String, Long> call(JavaRDD<ApacheAccessLog> rdd) {
                        return Functions.endpointCount(rdd);
                    }
                })
                .updateStateByKey(new Functions.ComputeRunningSum());

        Object ordering = Ordering.natural();
        final Comparator<Long> cmp = (Comparator<Long>) ordering;

        endpointCountsDStream.foreachRDD(new Function<JavaPairRDD<String, Long>, Void>() {
            /**
             * 
             */
            private static final long serialVersionUID = 5423471817787170189L;

            public Void call(JavaPairRDD<String, Long> rdd) {
                currentTopEndpoints = rdd.takeOrdered(
                        10,
                        new Functions.ValueComparator<String, Long>(cmp));
                return null;
            }
        });
    }

    public LogStatistics getLogStatistics() {
        if (runningCount.get() == 0) {
            return LogStatistics.EMPTY_LOG_STATISTICS;
        }

        return new LogStatistics(new Tuple4<>(runningCount.get(), runningSum.get(),
                runningMin.get(), runningMax.get()),
                currentResponseCodeCounts, currentIPAddresses, currentTopEndpoints);
    }
}
