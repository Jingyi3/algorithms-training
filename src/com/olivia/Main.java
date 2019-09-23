package com.olivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        int testNum = (0 - 1) / 2;
//        testNum = (4 - 1) / 2;
//        testNum = (0 - 3) / 2;
//        System.out.println(testNum);

        boolean[] x = new boolean[128];
        System.out.println(Arrays.toString(x));

        Main testVar = new Main();
        testVar.testforQ17("234");


    }

    public List<String> testforQ17(String digits) {

        List<String> ans = new ArrayList<String>();
        if(digits==null||digits.length()==0) return ans;
        char[][] map = new char[8][];
        map[0]="abc".toCharArray();
        map[1]="def".toCharArray();
        map[2]="ghi".toCharArray();
        map[3]="jkl".toCharArray();
        map[4]="mno".toCharArray();
        map[5]="pqrs".toCharArray();
        map[6]="tuv".toCharArray();
        map[7]="wxyz".toCharArray();

        char[] input = digits.toCharArray();
        ans.add("");
        for(char c:input) {
            System.out.println(c);
            System.out.println(map[c-'2']);
            ans = expand(ans, map[c - '2']);
        }
        return ans;
    }
    private List<String> expand(List<String> list, char[] arr) {
        List<String> next = new ArrayList<String>();
        for (String str : list) {
            for (char ch : arr)
                next.add(str + ch);
        }
        return next;
    }

}
