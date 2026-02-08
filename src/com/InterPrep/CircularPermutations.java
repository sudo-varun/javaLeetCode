package com.InterPrep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CircularPermutations {
    public List<Integer> circularPermutation(int n, int start) {
        int size = 1 << n;
        List<Integer> ans = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ans.add(start ^ i ^ (i >> 1));
        }
        return ans;
    }


    public static void main(String[] args) {
        CircularPermutations circularPermutations = new CircularPermutations();
        System.out.println(circularPermutations.circularPermutation(2,3));
    }

}
