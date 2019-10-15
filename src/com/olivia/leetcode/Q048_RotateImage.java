package com.olivia.leetcode;

public class Q048_RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int top = 0;
        int bot = matrix.length - 1;
        int left = 0;
        int right = matrix.length - 1;
        int n = matrix.length;
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                int tmp = matrix[top][left+i];
                matrix[top][left + i] = matrix[bot - i][left];
                matrix[bot - i][left] = matrix[bot][right - i];
                matrix[bot][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tmp;
            }
            top++;
            bot--;
            left++;
            right--;
            n -= 2;
        }
    }
}
