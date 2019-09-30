package com.olivia.leetcode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * x需要两个指针
 * fast每个看一遍 当前处理哪个数
 * slow发现不同放在什么位置
 *
 * 第一个元素放在最前面
 * fast向前
 * 如果curr和之前的数相同 则快向前，慢不懂
 * 如果curr和之前不同 则快指针的数换到慢指针 然后慢指针向前 快指针也向前
 *
 * fast到头了
 * 则slow的index就是length
 */
public class Q026_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast - 1] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }


}
