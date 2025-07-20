package com.InterPrep;

import java.util.Arrays;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][2];
        int left = 0, right = piles.length - 1;
        int aliceScore = 0, bobScore = 1;
        dp[left][aliceScore] = piles[left];
        dp[right][aliceScore] = piles[right];
        dp[left][bobScore] = piles[left];
        dp[right][bobScore] = piles[right];
        int aliceChance = 0;
        left++;
        right--;
        while(left <= right) {
            dp[left][aliceChance] = Math.max(dp[left-1][aliceChance], dp[right + 1][aliceChance]);
            dp[right][aliceChance] = Math.max(dp[left-1][aliceChance], dp[right + 1][aliceChance]);
            aliceChance = aliceChance == 0 ? 1 : 0;
            left++;
            right--;
        }
        return dp[left][aliceScore] > dp[left][bobScore];
    }

    public static void main(String[] args) {
        StoneGame stoneGame = new StoneGame();
        int[] input = {3,2,10,4};
        System.out.println(stoneGame.stoneGame(input));
    }
}
