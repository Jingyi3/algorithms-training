package com.olivia.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * 解法： 双指针
 * 移动所有指针比较小的一个（有瓶颈的那个）
 */
public class Q011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int area = 0, left = 0, right = height.length - 1;
        while (left < right) {
            area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) right--;
            else if (height[left] < height[right]) left++;
            else {
                left++;
                right--;
            }
        }
        return area;
    }

}
