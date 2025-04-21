package com.InterPrep;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length < 2) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[1] = nums[0];
        dp[2] = nums[1];
        int currMax = Math.max(nums[0], nums[1]);
        for(int i = 3; i < dp.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
            if(dp[i] > currMax) {
                currMax = dp[i];
            }
        }
        return currMax;
    }
}
