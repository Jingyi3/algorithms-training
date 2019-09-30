package com.olivia.leetcode;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * <p>
 * divisor除数（除号后面的那个数）
 */
public class Q029_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            else if (divisor == 1) return Integer.MIN_VALUE;
        }
        long divd = (long) dividend;
        long divs = (long) divisor;
        int sign = 1;
        if (divd < 0) {
            divd = -divd;
            sign = -sign;
        }
        if (divs < 0) {
            divs = -divs;
            sign = -sign;
        }

        int res = 0;
        while (divd >= divs) {
            int shift = 0;
            while (divd >= divs << shift) {
                shift++;
            }
            res += (1 << (shift - 1));
            divd -= (divs << (shift - 1));
        }
        return sign * res;
    }
}
