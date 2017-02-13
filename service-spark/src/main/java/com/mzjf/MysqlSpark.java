/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public final class MysqlSpark {

    public static void main(String[] args) throws Exception {

        JavaSparkContext ctx = new JavaSparkContext(new SparkConf().setMaster("local").setAppName(
                "MysqlSpark"));
        SQLContext sqlContext = new SQLContext(ctx);

        String[] predicates = new String[] { "user_roulette_log_id <= 1000000",
                "user_roulette_log_id > 1000000 and user_roulette_log_id <= 2000000",
                "user_roulette_log_id > 2000000 and user_roulette_log_id <= 3000000",
                "user_roulette_log_id > 3000000 and user_roulette_log_id <= 4000000",
                "user_roulette_log_id > 4000000 and user_roulette_log_id <= 000000"};
        String url = "jdbc:mysql://localhost:3306/sparkdb?user=root&password=123456";

        DataFrame dataFrame = sqlContext.jdbc(url, "user_roulette_log", predicates);
//        System.err.println(dataFrame.count());
        System.err.println(dataFrame.filter("roulette_status = 1").count());
        Thread.sleep(600000);
        ctx.stop();
    }
}
