package com.olivia.leetcode;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class Q034FindFirstandLastPositionofElementinSortedArray {
    public int[] serachRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        int startIndex = -1, endIndex = -1;
        int start = 0, end = nums.length - 1;
        //find the start point
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) end = mid;//大于等于
            else start = mid;
        }
        if (nums[start] == target) startIndex = start;
        else if (nums[end] == target) startIndex = end;
        if (startIndex == -1) return res;

        //find the end point
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) end = mid;//大于
            else start = mid;
        }
        if (nums[end] == target) endIndex = end;
        else if (nums[start] == target) endIndex = start;
//        这个非常自然的想法，没有二分法快
//        if (startIndex != -1) {
//            endIndex = startIndex;
//            for (int i = startIndex + 1; i < nums.length; i++) {
//                if (nums[i] == nums[startIndex]) endIndex = i;
//            }
//        }

        res[0] = startIndex;
        res[1] = endIndex;
        return res;
    }
}
