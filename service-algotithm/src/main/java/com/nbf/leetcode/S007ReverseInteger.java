package com.nbf.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S007ReverseInteger {

    private static Logger logger = LoggerFactory
            .getLogger(S007ReverseInteger.class);

    public static void main(String[] args) {
        int s = 1534236469;
        logger.info(String.valueOf(new S007ReverseInteger().reverse(s)));
    }

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) result;
    }
}
