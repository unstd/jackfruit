package com.github.unstd.jackfruit.core;

/**
 * @author unstd
 * @date 2021-06-26 21:01
 */
public class StringUtils {

    public static boolean isEmpty(String target) {
        return target == null || target.length() == 0;
    }

    public static boolean isNotEmpty(String target) {
        return !isEmpty(target);
    }

}
