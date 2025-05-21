package com.InterPrep.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        backtrack(new ArrayList<>(), 1, n, k);
        return result;
    }
    private void backtrack(List<Integer> curr, int index, int n, int k) {
        if(curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i <= n; i++) {
            curr.add(i);
            backtrack(curr, i + 1, n , k);
            curr.removeLast();
        }
    }
    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4,2));
    }
}
