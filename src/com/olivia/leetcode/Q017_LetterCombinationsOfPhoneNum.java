package com.olivia.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class Q017_LetterCombinationsOfPhoneNum {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if (digits == null || digits.length() == 0) return res;
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        helper("", 0, digits, res, map);
        return res;
    }

    public void helper(String curr, int currIdx, String digits, List<String> res, HashMap<Character, char[]> map) {
        if (currIdx == digits.length()) {
            res.add(curr);
        } else {
            char c = digits.charAt(currIdx);
            if (map.containsKey(c)) {
                for (char ch : map.get(c))
                    helper(curr + ch, currIdx + 1, digits, res, map);
            } else {

            }
        }
    }

    public List<String> letterCombinations_fastestSol(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        char[][] map = new char[8][];
        map[0] = "abc".toCharArray();
        map[1] = "def".toCharArray();
        map[2] = "ghi".toCharArray();
        map[3] = "jkl".toCharArray();
        map[4] = "mno".toCharArray();
        map[5] = "pqrs".toCharArray();
        map[6] = "tuv".toCharArray();
        map[7] = "wxyz".toCharArray();
        char[] input = digits.toCharArray();
        ans.add("");
        for (char ch : input) {
            ans = expend(ans, map[ch - '2']);
        }
        return ans;
    }

    private List<String> expend(List<String> list, char[] arr) {
        List<String> next = new ArrayList<String>();
        for (String str : list) {
            for (char ch : arr)
                next.add(str + ch);
        }
        return next;
    }

}












