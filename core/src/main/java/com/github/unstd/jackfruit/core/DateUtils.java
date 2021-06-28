package com.github.unstd.jackfruit.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author unstd
 * @date 2021-06-26 21:04
 */
public class DateUtils {

    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_DATE_YYYYMM = "yyyyMM";
    public static final String FORMAT_DATE_YYYY_MM = "yyyy-MM";
    public static final String FORMAT_DATE_YYYYMMDD = "yyyyMMdd";
    public static final String FORMAT_DATE_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMAT_DATE_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE_YYYYMMDD_HHMMSS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    public static String format(Date date, String format) {
        return date == null ? null : new SimpleDateFormat(format).format(date);
    }

    public static Date format(String date, String format) {
        try {
            if (StringUtils.isEmpty(date)) {
                return null;
            }
            SimpleDateFormat source = new SimpleDateFormat(format);
            return new Date(source.parse(date).getTime());
        } catch (ParseException ignore) {
        }
        return null;
    }

    public static Date addDays(Date date, int addedDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, addedDays);
        return cal.getTime();
    }

    public static Date addMonths(Date date, int addedMonths) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, addedMonths);
        return c.getTime();
    }

    public static Date addHours(Date date, int addedHours) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, addedHours);
        return c.getTime();
    }

    public static Date addMinutes(Date date, int addedMinutes) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, addedMinutes);
        return c.getTime();
    }

    public static Date addSeconds(Date date, int addedSeconds) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, addedSeconds);
        return c.getTime();
    }

    public static int age(Date birth) {
        Calendar today = Calendar.getInstance();
        Calendar birthday = Calendar.getInstance();
        birthday.setTime(birth);

        int todayYear = today.get(Calendar.YEAR);
        int todayMonth = today.get(Calendar.MONTH);
        int todayDate = today.get(Calendar.DAY_OF_MONTH);

        int birthdayYear = birthday.get(Calendar.YEAR);
        int birthdayMonth = birthday.get(Calendar.MONTH);
        int birthdayDate = birthday.get(Calendar.DAY_OF_MONTH);
        if (todayMonth < birthdayMonth) {
            return todayYear - birthdayYear - 1;
        }
        if (todayMonth > birthdayMonth) {
            return todayYear - birthdayYear;
        }
        if (todayDate < birthdayDate) {
            return todayYear - birthdayYear - 1;
        }
        return todayYear - birthdayYear;
    }

    public static int compare(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);

        return c1.compareTo(c2);
    }

    public static Date getFirstDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getLastDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

}
