package com.zxin.java.spring.melon.infrastructure.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zxin
 */
public class LocalDateTimeUtils {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    // String

    public static String format(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }

    public static LocalDateTime parse(String dateTime) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }

    // Instant

    public static Instant toInstant(LocalDateTime dateTime){
        return dateTime.atZone(DEFAULT_ZONE_ID).toInstant();
    }

    public static LocalDateTime ofInstant(Instant instant){
        return LocalDateTime.ofInstant(instant, DEFAULT_ZONE_ID);
    }

    // long

    public static long toEpochMilli(LocalDateTime dateTime) {
        return dateTime.atZone(DEFAULT_ZONE_ID).toInstant().toEpochMilli();
    }

    public static LocalDateTime ofEpochMilli(long ms) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(ms), DEFAULT_ZONE_ID);
    }

    // date

    public static Date toDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(DEFAULT_ZONE_ID).toInstant());
    }

    public static LocalDateTime ofDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), DEFAULT_ZONE_ID);
    }

    // localDate

    public static LocalDateTime ofLocalDate(LocalDate localDate){
        return localDate.atTime(0,0);
    }
}