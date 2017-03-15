package com.nbf.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class S008StringToInteger {

    private static Logger logger = LoggerFactory
            .getLogger(S008StringToInteger.class);

    public static void main(String[] args) {
        String s = "2147483648";
        logger.info(String.valueOf(new S008StringToInteger().myAtoi(s)));
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str == "") {
            return 0;
        }
        int result = 0;
        boolean nagative = false;
        boolean sign = false;
        int i = 0;
        int limit = -Integer.MAX_VALUE;
        int mulLimit = 0;
        if (str.length() > 0) {
            while (i < str.length() && str.charAt(i) == '0') {
                i++;
            }
            if (str.charAt(i) == '-') {
                sign = true;
                nagative = true;
                limit = Integer.MIN_VALUE;
                if (i == str.length()) {
                    return 0;
                }
            }
            if (str.charAt(i) == '+') {
                sign = true;
                if (i == str.length()) {
                    return 0;
                }
            }
            if (sign) {
                i++;
            }
            mulLimit = limit / 10;
            while (i < str.length()) {
                int digit = str.charAt(i++) - '0';
                if (digit < 0 || digit > 9) {
                    return nagative ? result : -result;
                }
                if (result < mulLimit) {
                    return -limit;
                }
                result *= 10;
                if (result < limit + digit) {
                    return -limit;
                }
                result -= digit;
            }
        }
        return nagative ? result : -result;
    }
}
