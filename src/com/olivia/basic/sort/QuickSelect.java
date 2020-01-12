package com.olivia.basic.sort;

public class QuickSelect {

    public int quickSelect(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        int targetK = right - k + 1;
        while (left < right) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 < k) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
        return 0;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = right;
        int slow = left-1;
        int fast = left;
        while (fast < pivot) {
            if (nums[fast] > nums[pivot]) {
                fast++;
            } else {
                slow++;
                swap(nums, slow, fast);
                fast++;
            }
        }
        swap(nums, ++slow, pivot);
        return slow;
    }
}
