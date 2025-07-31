package com.InterPrep.DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            int[][] dp = new int[m + 1][n + 1];
            char[] s = text1.toCharArray();
            char[] t = text2.toCharArray();
            for(int i = m - 1; i >= 0; i--) {
                for(int j = n - 1; j >= 0; j--) {
                    if(s[i] == t[j]) {
                        dp[i][j] = 1 + dp[i+1][j+1];
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                    }
                }
            }
            return dp[0][0];
        }
    public int recurse(String text1, String text2, int i, int j, int[][] memo) {
        if(text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        if(text1.charAt(0) == text2.charAt(0)) {
            return memo[i][j] = 1 + recurse(text1.substring(1), text2.substring(1), i + 1, j + 1, memo);
        }
        int len1 = recurse(text1.substring(1), text2, i + 1, j, memo);
        int len2 = recurse(text1, text2.substring(1), i, j + 1, memo);
        return memo[i][j] = Math.max(len1, len2);
    }
    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }
}
