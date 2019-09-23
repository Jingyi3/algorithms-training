package com.olivia.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 双指针
 * 注意不包括重复的
 */
public class Q015_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 2) return res;
        int n= nums.length;
        int i = 0;
        Arrays.sort(nums);
        while (i < n - 2) {
            int base = nums[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = base + nums[left] + nums[right];
                if (sum == 0) {
                    LinkedList<Integer> list = new LinkedList<Integer>();
                    list.add(base);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left = moveRight(nums, left + 1);
                    right = moveLeft(nums, right - 1);
                } else if (sum > 0) {
                    right = moveLeft(nums, right - 1);
                } else{
                    left = moveRight(nums, left + 1);
                }
            }
            i = moveRight(nums, i + 1);
        }
        return res;
    }

    public int moveLeft(int[] nums, int right) {
        while (right == nums.length - 1 || (right >= 0 && nums[right] == nums[right + 1])) {
            right--;
        }
        return right;
    }

    public int moveRight(int[] nums, int left) {
        while (left == 0 || (left < nums.length && nums[left] == nums[left - 1])) {
            left++;
        }
        return left;
    }
}
