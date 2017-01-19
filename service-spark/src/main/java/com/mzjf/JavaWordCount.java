/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf;

import scala.Tuple2;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.regex.Pattern;

public final class JavaWordCount {
    private static final Pattern SPACE = Pattern.compile(" ");

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {

        String filePath = "~/soft/spark-1.4.0-bin-hadoop2.4/README.md";
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("JavaWordCount");
        JavaSparkContext ctx = new JavaSparkContext(sparkConf);
        JavaRDD<String> lines = ctx.textFile(filePath, 1);

        JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(SPACE.split(s)));

        JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<String, Integer>(s, 1));

        JavaPairRDD<String, Integer> counts = ones.reduceByKey((a, b) -> a + b);

        for (Tuple2<?, ?> tuple : counts.collect()) {
            System.out.println(tuple._1() + ": " + tuple._2());
        }

        ctx.stop();
    }
}
