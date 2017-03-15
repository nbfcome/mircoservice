package com.nbf.leetcode;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S010RegularExpressionMatching {

    private static Logger logger = LoggerFactory
            .getLogger(S010RegularExpressionMatching.class);

    public static void main(String[] args) {
        String s = "2147483648";
        logger.info(String.valueOf(new S010RegularExpressionMatching().isMatch(s, s)));
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null || "".equals(s) || "".equals(p)) {
            return false;
        }
        if(p.charAt(0) == '*') {
            return false;
        }
        char preChar = s.charAt(0);
        if ( preChar == p.charAt(0)) {
            
        }
//        for (int i = 1, j = 1; i< s.length(); i++) {
//            
//        }
        return true;
    }
}
