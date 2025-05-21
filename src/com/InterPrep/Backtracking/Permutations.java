package com.InterPrep.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        backtrack(new ArrayList<>(), nums);
        return result;
    }
    private void backtrack(List<Integer> curr, int[] nums) {
        if(curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(curr.contains(nums[i])) {
                continue;
            }
            curr.add(nums[i]);
            backtrack(curr, nums);
            curr.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(nums));
    }
}
