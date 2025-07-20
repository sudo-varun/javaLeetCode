package com.InterPrep;

import java.util.*;


public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ans = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(ans.containsKey(complement)) {
                return new int[]{ans.get(complement), i};
            }
            ans.put(nums[i], i);
        }
        return new int[]{}; // Return an empty array if no solution is found
    }
    public static void main(String[] args) {
        TwoSum twoSum  = new TwoSum();
        int[] nums = new int[]{2,7,11,15};
        int[] ans = twoSum.twoSum(nums, 9);
        System.out.println(Arrays.toString(ans));
    }
}
