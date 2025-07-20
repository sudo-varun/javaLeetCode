package com.InterPrep.DynamicProgramming;

import java.util.Arrays;

public class MaxProfitIII {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0) return 0;
        int[][] dp=new int[3][n];
        for (int k=1;k<=2;k++){
            for (int i=1;i<n;i++){
                int min=prices[0];
                for (int j=1;j<=i;j++){
                    min=Math.min(min, prices[j]-dp[k-1][j-1]);
                }
                dp[k][i] = Math.max(dp[k][i-1], prices[i] - min);
            }
        }
        return dp[2][n-1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        MaxProfitIII maxProfit = new MaxProfitIII();

        System.out.println(maxProfit.maxProfit(prices));
    }
}
