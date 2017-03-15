package com.nbf.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S004LongestPalindromicSubstring {
    private static Logger logger = LoggerFactory
            .getLogger(S004LongestPalindromicSubstring.class);

    public static void main(String[] args) {
        String s = "dscddabccbac";
        logger.info(new S004LongestPalindromicSubstring().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int subStartPoint = 0;
        int maxLength = 1;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = testTwoSides(s, i, i);
            if (temp > maxLength) {
                subStartPoint = i - temp / 2;
                maxLength = temp;
            }
        }
        for (int i = 1; i < n; i++) {
            temp = testTwoSides(s, i - 1, i);
            if (temp > maxLength) {
                subStartPoint = i - temp / 2;
                maxLength = temp;
            }
        }
        return s.substring(subStartPoint, subStartPoint + maxLength);
    }

    public int testTwoSides(String s, int low, int up) {
        int n = s.length();
        int max = 0;
        if (low == up) {
            low--;
            up++;
            max = 1;
        }
        while (low >= 0 && up < n && s.charAt(low) == s.charAt(up)) {
            max += 2;
            low--;
            up++;
        }
        return max;
    }

}
