package com.olivia.leetcode.helper;

import java.util.HashMap;
import java.util.Map;

public class QuickTest {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        System.out.println(dummy.val);
        String s = "aabbccc";
        char[] chars = s.toCharArray();
        int res = compress(chars);
        for (int i = 0; i < res; i++) {
            System.out.println(chars[i]);
        }
    }

    public static  int compress(char[] chars) {
        int j = 0;
        for(int i = 1, cnt = 1; i <= chars.length; i++){
            if(i < chars.length && chars[i] == chars[i-1]) cnt++;
            else{
                chars[j++] = chars[i-1];
                if(cnt != 1){
                    char[] cs = String.valueOf(cnt).toCharArray();
                    for(char c : cs)
                        chars[j++] = c;
                    cnt = 1;
                }
            }
        }
        return j;
    }
}
