package com.InterPrep.DynamicProgramming;

public class MinimumFallSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int j = 0; j < m; j++) {
            dp[n-1][j] = matrix[n-1][j];
        }
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < m; j++) {
                if(j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                } else if (j == m - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j-1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], Math.min(dp[i+1][j-1], dp[i+1][j+1]));
                }
            }
        }
        int minSum = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++) {
            minSum = Math.min(minSum, dp[0][j]);
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[][] input = {
                {2,1,3},
                {6,5,4},
                {7,6,9}};
        MinimumFallSum minimumFallSum = new MinimumFallSum();
        System.out.println(minimumFallSum.minFallingPathSum(input));
    }
}
