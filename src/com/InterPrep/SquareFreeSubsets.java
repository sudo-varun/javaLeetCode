package com.InterPrep;

import com.DataStructures.Pair;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class SquareFreeSubsets {
    int ans = 0;
    public int squareFreeSubsets(int[] nums) {
        List<Set<Integer>> primeFactors = new ArrayList<>();
        for(int num: nums) {
            if(isSquareFree(num)) {
                primeFactors.add(getPrimeFactors(num));
            }
        }

        return ans;
    }

    public void backtrack(List<Set<Integer>> primeFactors, int curr) {
        if(primeFactors.isEmpty()) return;
        if(primeFactors.size() == 1) {
            ans++;
            return;
        }

    }


    // as max value of num can be 30 the prime factors can only be till 15
    static final Set<Integer> primes = Set.of(2,3,5,7,11,13);
    static final Set<Integer> squares = Set.of(4, 9);
    //
    public Set<Integer> getPrimeFactors(int num) {
        Set<Integer> factors = new HashSet<>();
        for(Integer prime: primes) {
            if(num % prime == 0) {
                factors.add(prime);
            }
        }
        return factors;
    }
    public boolean isSquareFree(int num) {
        for(int square: squares) {
            if(num % square == 0) return false;
        }
        return true;
    }



    public static void main(String[] args) {
        SquareFreeSubsets sfs = new SquareFreeSubsets();
        System.out.println(sfs.getPrimeFactors(4));
    }
}
