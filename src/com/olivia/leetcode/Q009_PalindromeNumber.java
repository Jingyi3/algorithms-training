package com.olivia.leetcode;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 */
public class Q009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1, num = x;
        while (num / div >= 10) {
            div *= 10;
        }
        while (num != 0) {
            int left = num / div;
            int right = num % 10;
            if (left != right) return false;
            num = (num - left * div) / 10;
            div /= 10;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        String s = String.valueOf(x);
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}
