package com.olivia.leetcode;

import java.util.Arrays;

public class Q455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) i++;
        }
        return i;

    }
}
