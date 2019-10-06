package com.olivia.leetcode;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * <p>
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Q043_MultipleStrings {
    public String Multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int posLow = i + j + 1;
                int posHigh = i + j;
                mul += result[posLow];
                result[posLow] = mul % 10;
                result[posHigh] += mul / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int res : result) {
            if (!(sb.length() == 0 && res == 0)) sb.append(res);
        }
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}
