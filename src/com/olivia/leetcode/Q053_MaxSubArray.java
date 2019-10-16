package com.olivia.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Q053_MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], maxToCurr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxToCurr = Math.max(nums[i], maxToCurr + nums[i]);
            max = Math.max(max, maxToCurr);
        }

        return max;

    }
}
