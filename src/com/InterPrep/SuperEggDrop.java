package com.InterPrep;

import java.util.Arrays;

public class SuperEggDrop {
    public int superEggDrop(int k, int n) {
        if(n==0||n==1) return n;     //Think for base case
        if(k==1) return k;
        int[][] dp = new int[k + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            dp[1][i] = i;
        }
        for(int i = 1; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for(int i = 2; i <= k; i++) {
            for(int j = 2; j <= n; j++) {
                int low = 1, high = j;
                int result = Integer.MAX_VALUE;
                while(low <= high) {
                    int mid = (low + high) / 2;
                    int left = dp[i-1][mid-1];
                    int right = dp[i][j-mid];
                    int attempts = 1;
                    if(left < right) {
                        low = mid + 1;
                        attempts += right;
                    } else {
                        high = mid - 1;
                        attempts += left;
                    }
                    result = Math.min(result, attempts);
                }
                dp[i][j] = result;
            }
        }
        return dp[k][n];
    }
}
