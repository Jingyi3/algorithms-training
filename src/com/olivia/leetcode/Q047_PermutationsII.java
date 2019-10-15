package com.olivia.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * input arr包括重复数字
 */
public class Q047_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        permuteUniqueHelper(nums, new boolean[nums.length], new LinkedList<>(), res);
        return res;
    }

    private void permuteUniqueHelper(int[] nums, boolean[] used, List<Integer> curList, List<List<Integer>> result) {
        if (curList.size() == nums.length) {
            result.add(new LinkedList<Integer>(curList));
        } else {
            int preNum = nums[0] - 1;
            for (int i = 0; i < nums.length; i++) {
                if (!used[i] && nums[i] != preNum) {
                    preNum = nums[i];
                    curList.add(nums[i]);
                    used[i] = true;
                    permuteUniqueHelper(nums, used, curList, result);
                    used[i] = false;
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }
}
