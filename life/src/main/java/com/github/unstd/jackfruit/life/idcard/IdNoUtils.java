package com.github.unstd.jackfruit.life.idcard;

import com.github.unstd.jackfruit.core.DateUtils;
import com.github.unstd.jackfruit.core.StringUtils;
import com.github.unstd.jackfruit.life.enums.Gender;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 身份证号工具类
 *
 * @author unstd
 */
public class IdNoUtils {
    private static final Pattern PATTERN_MALE = Pattern.compile("^\\d{14}[13579]$|^\\d{16}[13579][0-9Xx]$");
    private static final Pattern PATTERN_FEMALE = Pattern.compile("^\\d{14}[24680]$|^\\d{16}[24680][0-9Xx]$");
    private static final Pattern PATTERN_DATE = Pattern.compile("^\\d{6}(\\d{6})\\d{3}$|^\\d{6}(\\d{8})[0-9Xx]{4}$");
    private static final Pattern PATTERN_YEAR = Pattern.compile("^\\d{6}(\\d{2})\\d{7}$|^\\d{6}(\\d{4})[0-9Xx]{8}$");
    private static final Pattern PATTERN_MONTH = Pattern.compile("^\\d{8}(\\d{2})\\d{5}$|^\\d{10}(\\d{2})[0-9Xx]{6}$");
    private static final Pattern PATTERN_DAY = Pattern.compile("^\\d{10}(\\d{2})\\d{3}$|^\\d{12}(\\d{2})[0-9Xx]{4}$");

    /**
     * 提取身份证号中的性别，支持15位和18位
     * @param idNo 身份证号
     * @return Gender
     */
    public static Gender extractGender(String idNo) {
        if (StringUtils.isEmpty(idNo)) {
            return Gender.UNKNOWN;
        }
        if (PATTERN_MALE.matcher(idNo).find()) {
            return Gender.MALE;
        } else if (PATTERN_FEMALE.matcher(idNo).find()) {
            return Gender.FEMALE;
        } else {
            return Gender.UNKNOWN;
        }
    }

    /**
     * 提取身份证号中的年份，支持15位和18位
     * @param idNo 身份证号
     * @return Integer
     */
    public static Integer extractYear(String idNo) {
        if (StringUtils.isEmpty(idNo)) {
            return 0;
        }
        Matcher matcher = PATTERN_YEAR.matcher(idNo);
        if (matcher.find()) {
            String y = matcher.group(1);
            if (StringUtils.isNotEmpty(y)) {
                return Integer.valueOf("19" + y);
            }
            y = matcher.group(2);
            if (StringUtils.isNotEmpty(y)) {
                return Integer.valueOf(y);
            }
        }
        return 0;
    }

    /**
     * 提取身份证号中的月份，支持15位和18位
     * @param idNo 身份证号
     * @return Integer
     */
    public static Integer extractMonth(String idNo) {
        if (StringUtils.isEmpty(idNo)) {
            return 0;
        }
        Matcher matcher = PATTERN_MONTH.matcher(idNo);
        if (matcher.find()) {
            String y = matcher.group(1);
            if (StringUtils.isEmpty(y)) {
                y = matcher.group(2);
            }
            if (StringUtils.isNotEmpty(y)) {
                return Integer.valueOf(y);
            }
        }
        return 0;
    }

    /**
     * 提取身份证号中的日，支持15位和18位
     * @param idNo 身份证号
     * @return Integer
     */
    public static Integer extractDay(String idNo) {
        if (StringUtils.isEmpty(idNo)) {
            return 0;
        }
        Matcher matcher = PATTERN_DAY.matcher(idNo);
        if (matcher.find()) {
            String y = matcher.group(1);
            if (StringUtils.isEmpty(y)) {
                y = matcher.group(2);
            }
            if (StringUtils.isNotEmpty(y)) {
                return Integer.valueOf(y);
            }
        }
        return 0;
    }

    /**
     * 提取身份证号中的日期，支持15位和18位
     * @param idNo 身份证号
     * @return Integer or null
     */
    public static Date extractDate(String idNo) {
        if (StringUtils.isEmpty(idNo)) {
            return null;
        }
        Matcher matcher = PATTERN_DATE.matcher(idNo);
        if (matcher.find()) {
            String y = matcher.group(1);
            if (StringUtils.isNotEmpty(y)) {
                y = "19" + y;
            } else {
                y = matcher.group(2);
            }
            if (StringUtils.isNotEmpty(y)) {
                return DateUtils.format(y, DateUtils.FORMAT_DATE_YYYYMMDD);
            }
        }
        return null;
    }
}
