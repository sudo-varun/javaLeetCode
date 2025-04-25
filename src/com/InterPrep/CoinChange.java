package com.InterPrep;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int c: coins) {
                if(i - c >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    private int dfs(int[] coins, int currAmount, int[] dp) {
        if(currAmount < 0) {
            return Integer.MAX_VALUE;
        }
        if(currAmount == 0) {
            return 0;
        }
        if(dp[currAmount] > 0) {
            return dp[currAmount];
        }
        int minAmount = Integer.MAX_VALUE;
        for(int coin: coins) {
            int noOfCoins = dfs(coins, currAmount - coin, dp);
            if(noOfCoins != Integer.MAX_VALUE) {
                if(noOfCoins < minAmount) {
                    minAmount = noOfCoins;
                }
            }
        }
        // make sure the min amount does not overflow
        if (minAmount != Integer.MAX_VALUE) {
            dp[currAmount] = 1 + minAmount;
        } else {
            dp[currAmount] = Integer.MAX_VALUE;
        }
        return dp[currAmount];
    }
}
