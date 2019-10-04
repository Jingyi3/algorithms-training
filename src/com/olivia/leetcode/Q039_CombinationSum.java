package com.olivia.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class Q039_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0) return results;
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, results, new ArrayList());
        return results;
    }

    private void combinationSumHelper(int[] candidates, int target, int index, List<List<Integer>> results, List<Integer> curSeq) {
        if (target == 0) results.add(curSeq);
        else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] > target) break;
                curSeq.add(candidates[i]);
                combinationSumHelper(candidates, target - candidates[i], i, results, curSeq);
                curSeq.remove(curSeq.size() - 1);
            }
        }
    }
}
