package com.InterPrep.DynamicProgramming;

import java.util.Arrays;

public class JumpGameII {
    int maxJumps = 10001;
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, maxJumps);
        System.out.println(Arrays.toString(dp));
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int jumpLen = 1; jumpLen <= nums[i]; jumpLen++) {
                dp[i] = Math.min(dp[i], 1 + dp[Math.min(n-1, i + jumpLen)]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        System.out.println(nums.length);
        System.out.println(jumpGameII.jump(nums));
    }
}
