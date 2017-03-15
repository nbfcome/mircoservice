package com.nbf.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S001TwoSum {
    private static Logger logger = LoggerFactory.getLogger(S001TwoSum.class);

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 4 };
        int target = 6;
        int[] result = new S001TwoSum().twoSum(nums, target);
        if (result.length == 2) {
            logger.info("{} , {}", result[0], result[1]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] { map.get(temp), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

}
