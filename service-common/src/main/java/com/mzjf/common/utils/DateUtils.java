/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Utility functions for date related logic.
 */
public class DateUtils {

    /**
     * Convert Long to String of Day for targeted time zone.
     * @param epochTime
     * @param timeZone
     * @return
     */
    public static String epochTimeToDay(long epochTime, String timeZone) {
        Date date = new Date(epochTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        return simpleDateFormat.format(date);
    }

    /**
     * Convert Long to String of Day for targeted time zone.
     * @param epochTime second
     * @param timeZone
     * @return
     */
    public static String epochSecondToDay(long epochTime, String timeZone) {
        Date date = new Date(epochTime * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        return simpleDateFormat.format(date);
    }

    /**
     * Convert String of day to epoch time for targeted time zone.
     * @param day
     * @param timeZone
     * @return
     * @throws ParseException
     */
    public static long dayToMilliSeconds(String day, String timeZone) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        return simpleDateFormat.parse(day).getTime();
    }

    /**
     * Convert String of day to epoch time for targeted time zone.
     * @param day
     * @param timeZone
     * @return
     * @throws ParseException
     */
    public static long dayToSeconds(String day, String timeZone) throws ParseException {
        return dayToMilliSeconds(day, timeZone) / 1000;
    }

    /**
     * Convert String of day to epoch time for UTC
     * @param day
     * @return
     * @throws ParseException
     */
    public static long dayToUTCSeconds(String day) throws ParseException {
        return dayToSeconds(day, "UTC");
    }

    /**
     * Convert String of day to Date type
     *
     * @param time
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String time, String format) throws ParseException {
        DateFormat formater = new SimpleDateFormat(format);
        return formater.parse(time);
    }

    /**
     * Get day of week
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }
}
