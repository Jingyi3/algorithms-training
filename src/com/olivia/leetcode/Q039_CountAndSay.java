package com.olivia.leetcode;

/**
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */
public class Q039_CountAndSay {
    public String countAndSay(int n) {
        if(n<=0) return "";
        String str = "1";
        for (int i = 1; i < n; i++) {
            int count =0;
            char prev = '.';
            StringBuilder sb = new StringBuilder();
            for (int idx = 0; idx < str.length(); idx++) {
                if (str.charAt(idx) == prev || prev == '.') {
                    count++;
                } else {
                    sb.append(count).append(Character.toString(prev));
                    count = 1;
                }
                prev = str.charAt(idx);
            }
            sb.append(count).append(Character.toString(prev));
            str = sb.toString();
        }
        return str;
    }
}
