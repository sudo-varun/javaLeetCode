package com.InterPrep;

import java.util.*;

public class MaxAlternatingSum {
    public long maxAlternatingSum(int[] nums) {
        long[] dpe = new long[nums.length+1], dpo = new long[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            dpe[i+1] = Math.max(dpe[i], dpo[i] - nums[i]);
            dpo[i+1] = Math.max(dpo[i], dpe[i] + nums[i]);
        }

        return Math.max(dpe[nums.length], dpo[nums.length]);
    }
    public static void main(String[] args) {
        MaxAlternatingSum maxAlternatingSum = new MaxAlternatingSum();
        int[] input = new int[]{6,2,1,2,4,5};
        System.out.println(maxAlternatingSum.maxAlternatingSum(input));
    }
}
