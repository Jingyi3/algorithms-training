package com.olivia.leetcode;

import java.util.Stack;

/**
 * parenthesis  n. 圆括号
 * <p>
 * <p>
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * 使用 stack
 * 很像compile
 */
public class Q020_ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> mark = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                mark.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (mark.isEmpty()) return false;
                char cur = mark.pop();

                if (cur == '(' && s.charAt(i) != ')') return false;
                if (cur == '[' && s.charAt(i) != ']') return false;
                if (cur == '{' && s.charAt(i) != '}') return false;
            }
        }
        if (mark.isEmpty()) return true;
        return false;
    }
}
