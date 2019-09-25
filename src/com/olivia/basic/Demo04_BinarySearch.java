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
        while (start + 1 < end) {//当两个指针相遇的时候
            int mid = start + (end - start) / 2;//防止overflow（如果直接相加/2）
            if (nums[mid] < target) start = mid;//移动指针的时候直接=mid而不是mid+1 或者mid-1
            else if (nums[mid] > target) end = mid;
            else return mid;
        }
        //while循环结束后 根据题意，一次检测，在剩下的这两个start和end位置上对应的数，返回搜索的结果
        if (nums[end] < target) return end + 1;
        else if (nums[start] >= target) return start;
        else return end;
    }
}
