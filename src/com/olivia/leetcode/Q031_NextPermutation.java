package com.olivia.leetcode;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Q031_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int replace = nums.length - 2;
        while (replace > 0) {
            if (nums[replace] < nums[replace + 1]) break;
            replace--;
        }
        if (replace < 0) {// 6 5 4 3 2 1
            Arrays.sort(nums);
            return;
        }

        //replace curr number with cloest larger number;
        int largerIndex = replace + 1;
        while (largerIndex < nums.length && nums[largerIndex] > nums[replace]) {
            largerIndex++;
        }
        int tmp = nums[replace];
        nums[replace] = nums[largerIndex - 1];
        nums[largerIndex - 1] = tmp;
        Arrays.sort(nums, replace + 1, nums.length);
    }
}
