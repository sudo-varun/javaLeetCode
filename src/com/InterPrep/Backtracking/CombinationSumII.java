package com.InterPrep.Backtracking;

import java.util.*;

public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }
    private void backtrack(int[] candidates, int currTarget, List<Integer> currList, int idx) {
        if(res.contains(currList)){
            return;
        }
        if(currTarget == 0) {
            res.add(new ArrayList<>(currList));
            return;
        }
        for(int i = idx; i < candidates.length; i++) {
            int currElement = candidates[i];
            if(i > 0 && currElement == candidates[i-1]) {
                continue;
            }
            int remainingTarget = currTarget - currElement;
            if(remainingTarget < 0) {
                continue;
            }
            currList.add(currElement);
            backtrack(candidates, remainingTarget, currList, i + 1);
            currList.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> ans = combinationSumII.combinationSum2(candidates, 8);
        System.out.println(ans);
    }
}
