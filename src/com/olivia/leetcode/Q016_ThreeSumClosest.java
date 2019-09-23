package com.olivia.leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 包括重复的
 * <p>
 * 双指针
 */

public class Q016_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return target;
        Arrays.sort(nums);
        int delta = nums[0] + nums[1] + nums[2] - target;
        for (int baseIdx = 0; baseIdx < nums.length - 2; baseIdx++) {
            int start = baseIdx + 1;
            int end = nums.length - 1;
            while (start < end) {
                int newDelta = nums[baseIdx] + nums[start] + nums[end] - target;
                if (newDelta == 0) return target;
                if (Math.abs(delta) > Math.abs(newDelta))
                    delta = newDelta;
                if (newDelta < 0) start++;
                else end--;
            }
        }
        return target + delta;
    }
}
