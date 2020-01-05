package com.olivia.leetcode;

public class Q076_MinimumWindowSubstring {

    public static void main(String[] args) {
        Q076_MinimumWindowSubstring test = new Q076_MinimumWindowSubstring();
//        String s = "HSAXABSADCDHHGFHGVUABSAGGCKJHGJFGJFKAFBFASDA";
//        String t = "AABC";
//        String minSubstring = test.minWindow(s, t);
//        System.out.println(minSubstring);

    }
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        int matchCount = 0;
        String res = "";
        int[] tArr = new int[256];
        int[] sArr = new int[256];
        for (char c : t.toCharArray()) {
            tArr[c]++;
        }
        int left = findNextStringIndex(0, s, tArr);
        if (left == s.length()) {
            return "";
        }
        int right = left;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (sArr[rightChar] < tArr[rightChar]) {
                matchCount++;
            }
            sArr[rightChar]++;
            while (left < s.length() && matchCount == t.length()) {
                if (res.isEmpty() || res.length() > right - left + 1) {
                    res = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                if (sArr[leftChar] <= tArr[leftChar]) {
                    matchCount--;
                }
                sArr[leftChar]--;
                left = findNextStringIndex(left + 1, s, tArr);
            }
            right = findNextStringIndex(right + 1, s, tArr);
        }
        return res;

    }

    private int findNextStringIndex(int start, String s, int[] tArr) {
        while (start < s.length()) {
            char c = s.charAt(start);
            if (tArr[c] != 0) {
                return start;
            }
            start++;
        }
        return start;
    }
}
