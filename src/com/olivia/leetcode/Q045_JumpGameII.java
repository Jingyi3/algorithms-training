package com.olivia.leetcode;

public class Q045_JumpGameII {
    public int jump(int[] nums) {
        if(nums==null||nums.length<=1) return 0;
        int currMax=0;
        int nextmax=0;
        int step=0;
        int index=0;
        while (index <= currMax) {
            while (index <= currMax) {
                nextmax = Math.max(nextmax, index + nums[index]);
                index++;
            }
            currMax = nextmax;
            step++;
            if (currMax >= nums.length - 1) {
                return step;
            }
        }
        return 0;
    }
}
