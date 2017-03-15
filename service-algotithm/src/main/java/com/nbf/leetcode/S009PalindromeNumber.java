package com.nbf.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S009PalindromeNumber {

    private static Logger logger = LoggerFactory
            .getLogger(S009PalindromeNumber.class);

    public static void main(String[] args) {
        int x = 12321;
        logger.info(String.valueOf(new S009PalindromeNumber().isPalindrome(x)));
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;

        int base = 1;
        while (x / base >= 10)
            base *= 10;

        while (x != 0) {
            int leftDigit = x / base;
            int rightDigit = x % 10;
            if (leftDigit != rightDigit)
                return false;

            x -= base * leftDigit;
            base /= 100;
            x /= 10;
        }

        return true;
        //        if (x < 0) {
        //            return false;
        //        }
        //        if (x == 0) {
        //            return true;
        //        }
        //        int len = 0;
        //        int temp = x;
        //        while (temp != 0) {
        //            len++;
        //            temp /= 10;
        //        }
        //        char[] chars = new char[len];
        //        while (len-- > 0) {
        //            chars[len] = (char) (x % 10);
        //            x /= 10;
        //        }
        //        len = chars.length - 1;
        //        for (int i = 0; i <= chars.length / 2; i++) {
        //            if (chars[i] != chars[len - i]) {
        //                return false;
        //            }
        //        }
        //        return true;
    }

}
