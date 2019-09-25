package com.olivia.basic;

/**
 * start, mid, end
 * O(logn) 因为每次都减少一半解的空间
 */
public class Demo04_BinarySearch {
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid;
            else if (nums[mid] > target) end = mid;
            else return mid;
        }
        if (nums[end] < target) return end + 1;
        else if (nums[start] >= target) return start;
        else return end;
    }
}
