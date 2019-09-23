package com.olivia.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Input: -123
 * Output: -321
 * <p>
 * Integer最大是(2^31-1)如果reverse了那就会超出，所以需要检查一下
 * 负数
 * -123/10=-12
 * -123%10=-3
 * 所以负数的操作和正数一样
 */

public class Q007_ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int newrev = rev * 10 + x % 10;
            if ((newrev - x % 10) / 10 != rev) return 0;
            rev = newrev;
            x /= 10;
        }
        return rev;
    }
}
