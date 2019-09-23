package com.olivia.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Q003_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcacsdksbwcjl";
        Q003_LengthOfLongestSubstring test = new Q003_LengthOfLongestSubstring();
        int res = test.lengthOfLongestSubstring$(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    public int lengthOfLongestSubstring_slidingWindow(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j++))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            //j代表我们不重复的起点
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring$(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0, n = s.length();
        boolean[] used = new boolean[128];//初始化一个boolean数组 他的所有内容都是false 其中boolean的下标是该字符对应的acii码
        int max = 0;
        while (right < n) {
            if (!used[s.charAt(right)]) {
                used[s.charAt(right)] = true;
                right++;
            } else {
                max = Math.max(max, right - left);
                while (left < right && s.charAt(right) != s.charAt(left)) {
                    used[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }

    public int lengthOfLongestSubstring3(String s) {
        //不对
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }

}
