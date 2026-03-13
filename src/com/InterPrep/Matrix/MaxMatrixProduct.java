package com.InterPrep.Matrix;

import java.util.Arrays;

public class MaxMatrixProduct {
    static final int MOD = 1_000_000_007;
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[m-1][n-1] == 0 || grid[0][0] == 0) return 0;
        long[][] maxDP = new long[m][n];
        long[][] minDP = new long[m][n];

        maxDP[0][0] = grid[0][0];
        minDP[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            maxDP[0][i] = maxDP[0][i - 1] * grid[0][i];
            minDP[0][i] = minDP[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            maxDP[i][0] = maxDP[i - 1][0] * grid[i][0];
            minDP[i][0] = minDP[i - 1][0] * grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];
                if(val < 0) {
                    maxDP[i][j] = Math.min(minDP[i-1][j], minDP[i][j-1]) * val;
                    minDP[i][j] = Math.max(maxDP[i-1][j], maxDP[i][j-1]) * val;
                } else {
                    maxDP[i][j] = Math.max(maxDP[i-1][j], maxDP[i][j-1]) * val;
                    minDP[i][j] = Math.min(minDP[i-1][j], minDP[i][j-1]) * val;
                }
            }
        }
        long ans = maxDP[m - 1][n - 1];
        if (ans < 0) return -1;
        return (int) (ans % MOD);
    }


    public static void main(String[] args) {
        int[][] grid = {{1,-2,1},{1,-2,1},{3,-4,1}};
        MaxMatrixProduct maxMatrixProduct = new MaxMatrixProduct();
        // expected = 459630706
        System.out.println(maxMatrixProduct.maxProductPath(grid));
    }
}
