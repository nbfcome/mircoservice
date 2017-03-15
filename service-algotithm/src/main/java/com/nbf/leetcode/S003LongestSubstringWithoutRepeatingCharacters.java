package com.nbf.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S003LongestSubstringWithoutRepeatingCharacters {
    private static Logger logger = LoggerFactory
            .getLogger(S003LongestSubstringWithoutRepeatingCharacters.class);

    public static void main(String[] args) {
        String string = "abcabcdabc";
        logger.info(String.valueOf(new S003LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring(string)));
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] repeats = new int[128];
        for (int i = 0, j = 0; j < s.length(); j++) {
            i = Math.max(repeats[s.charAt(j)], i);
            ans = Math.max(ans, j + 1 - i);
            repeats[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
