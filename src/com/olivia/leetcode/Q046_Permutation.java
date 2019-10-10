package com.olivia.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * 递归
 */
public class Q046_Permutation {
    public List<List<Integer>> permute(int nums[]) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        permutationHelper(res, new LinkedList<>(), nums, new HashSet<>());
        return res;


    }

    private void permutationHelper(List<List<Integer>> res, List<Integer> clist, int[] nums, HashSet<Integer> set) {
        if(clist.size()==nums.length) res.add(new LinkedList<>(clist));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!set.contains(nums[i])) {
                    clist.add(nums[i]);
                    int last = clist.size() - 1;
                    set.add(nums[i]);
                    permutationHelper(res, clist, nums, set);
                    set.remove(nums[i]);
                    clist.remove(last);
                }
            }
        }
    }

}
