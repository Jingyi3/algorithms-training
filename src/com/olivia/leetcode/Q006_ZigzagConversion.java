package com.olivia.leetcode;


import javax.swing.plaf.basic.BasicScrollPaneUI;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 * 解法 StringBuilder[row]
 *
 */
public class Q006_ZigzagConversion {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] stringBuilders = new StringBuilder[numRows];

        int indexOfString = 0;
        while (indexOfString < len) {
            for (int idx = 0; idx < numRows && idx < len; idx++) {
                stringBuilders[idx].append(c[indexOfString++]);
            }
            for (int idx = numRows - 2; idx >= 1 && idx < len; idx--) {
                stringBuilders[idx].append(c[indexOfString++]);
            }
        }
        for (int idx = 1; idx < stringBuilders.length; idx++) {
            stringBuilders[0].append(stringBuilders[idx]);
        }
        return stringBuilders[0].toString();
    }
}
