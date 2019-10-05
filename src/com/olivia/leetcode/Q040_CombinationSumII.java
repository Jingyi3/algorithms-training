package com.olivia.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q040_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> curSeq = new ArrayList<>();
        if (candidates == null ) return results;
        Arrays.sort(candidates);
        combinantionSumHelper(candidates, target, 0, curSeq, results);
        return results;
    }

    private void combinantionSumHelper(int[] candidates, int target, int index, List<Integer> curSeq, List<List<Integer>> results) {
        if(target==0) results.add(new ArrayList<Integer>(curSeq));
        else if (target < 0) {
            for (int i = index; i < candidates.length; i++) {
                if (i != index && candidates[i] != candidates[i - 1]) continue;
                curSeq.add(candidates[i]);
                combinantionSumHelper(candidates, target - candidates[i], i, curSeq, results);
                curSeq.remove(curSeq.size() - 1);
            }
        }

    }
}
