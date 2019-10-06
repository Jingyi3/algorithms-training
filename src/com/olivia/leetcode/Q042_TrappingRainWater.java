package com.olivia.leetcode;

public class Q042_TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int max = 0;
        int leftMax = 0;
        int rightMax = 0;
        int leftIdx = 0;
        int rightIdx = height.length - 1;
        while (leftIdx < rightIdx) {
            leftMax = Math.max(leftMax, height[leftIdx]);
            rightMax = Math.max(rightMax, height[rightIdx]);
            if (leftMax < rightMax) {
                max += leftMax - height[leftIdx];
                leftIdx++;
            } else {
                max += rightMax - height[rightIdx];
                rightIdx--;
            }
        }
        return max;
    }
}
