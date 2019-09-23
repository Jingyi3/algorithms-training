package com.olivia.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * 回溯法 backtracking
 */
public class Q22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper("", res, n, 0, 0);
        return res;

    }

    public void helper(String curr, List<String> res, int n, int left, int right) {
        if (right == n) {
            res.add(curr);
            return;
        }
        if (left < n) {
            helper(curr + "(", res, n, left + 1, right);
        }
        if (left > right) {
            helper(curr + ")", res, n, left, right + 1);
        }

    }

}
