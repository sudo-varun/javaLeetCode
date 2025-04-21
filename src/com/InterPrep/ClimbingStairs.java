package com.InterPrep;

public class ClimbingStairs {
    public int climbStairsRecursive(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairsRecursive(n-1) + climbStairsRecursive(n-2);
    }
    public int climbStairsDP(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
