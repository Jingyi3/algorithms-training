package com.olivia.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Q697 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,1,4,2};

        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        if(nums==null||nums.length==0) return 0;

        int maxD=1;
        int minLen=1;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int idx = 0; idx<nums.length; idx++){
            if(!map.containsKey(nums[idx])) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(idx);
                arr.add(1);
                arr.add(1);
                map.put(nums[idx], arr);
            } else {
                int currD = map.get(nums[idx]).get(1);
                int currLen = map.get(nums[idx]).get(2);
                currD++;
                currLen = idx - map.get(nums[idx]).get(0)+1;
                map.get(nums[idx]).add(1,currD);
                map.get(nums[idx]).add(2,currLen);
                if(currD==maxD) {

                    minLen = Math.min(minLen, currLen);
                }
                if(currD>maxD) {
                    maxD = currD;
                    minLen = currLen;
                }

            }
        }
        return minLen;

    }
}
