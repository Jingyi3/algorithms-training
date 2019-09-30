package com.olivia.leetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * 动态规划的方法解
 */
public class Q005_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int len = s.length();
        char[] sChar = s.toCharArray();
        int start = 0;
        int length = 1;
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < len-1; i++) {
            if (sChar[i] == sChar[i + 1]) {
                isPalindrome[i][i + 1] = true;
                start = i;
                length = 2;
            }
        }
        for (int i = 3; i <= len; i++) {//i is the length of the current substring
            for (int j = 0; j + i - 1 < len; j++) {
                if (sChar[j] == sChar[j + i - 1] && isPalindrome[j + 1][j + i - 2]) {
                    isPalindrome[j][j + i - 1] = true;
                    start = j;
                    length = i;
                }
            }

        }
        return s.substring(start, start + length);
    }
}
