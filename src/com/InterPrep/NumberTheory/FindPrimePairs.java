package com.InterPrep.NumberTheory;

import java.util.*;


public class FindPrimePairs {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= n; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }
        for (int i = 0; i < isPrime.length; i++) {
            if(isPrime[i]) System.out.print(i + ", ");
        }
        return ans;
    }

    public static void main(String[] args) {
        FindPrimePairs findPrimePairs = new FindPrimePairs();
        System.out.println(findPrimePairs.findPrimePairs(100));
    }
}
