package com.InterPrep.Backtracking;

import java.util.*;

public class CombinationSum {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, target,  candidates);
        return res;
    }
    private void backtrack(List<Integer> curr, int idx, int currTarget, int[] candidates) {
        if(currTarget == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i < candidates.length; i++) {
            int currInt = candidates[i];
            if(currTarget < candidates[i]) {
                continue;
            }
            curr.add(i);
            backtrack(curr, i, currTarget - currInt, candidates);
            curr.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] input = new int[]{2,3,5};
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(input, 8));
    }
}
