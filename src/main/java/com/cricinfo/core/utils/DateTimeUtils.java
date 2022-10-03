package com.cricinfo.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
public class DateTimeUtils {

    public static Date adjustTimeZone(String pattern, String dateStr, String tzId) {
        return adjustTimeZone(convertStringToDate(pattern, dateStr), tzId);
    }

    public static Date convertStringToDate(String pattern, String strDate) {
        SimpleDateFormat df;
        Date date;
        df = new SimpleDateFormat(pattern);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            throw new RuntimeException(pe.getMessage(), pe);
        }

        return (date);
    }

    public static Date adjustTimeZone(Date date, String tzId) {
        return new Date(date.getTime() - getTimezoneOffset(tzId, date));
    }

    private static int getTimezoneOffset(String timezoneId, Date date) {
        return TimeZone.getTimeZone(timezoneId).getOffset(date.getTime()) - TimeZone.getDefault().getOffset(date.getTime());
    }

    public static long convertHHmmssToSeconds(String hhmmss) {
        String[] strArray = StringUtils.split(hhmmss, ":");
        int hour = Integer.parseInt(strArray[0]);
        int minutes = Integer.parseInt(strArray[1]);
        int seconds = Integer.parseInt(strArray[2]);
        return (hour * 3600L) + (minutes * 60L) + seconds;
    }

    public static String getDateString(String pattern, Date date) {
        SimpleDateFormat df = null;
        if (date == null) {
            log.warn("date is null!");
            return "";
        }
        df = new SimpleDateFormat(pattern);
        return df.format(date);
    }


    public static Date changeDateTimeElements(Date date, int hour, int minute, int second) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, second);
        return c.getTime();
    }
}