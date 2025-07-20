package com.InterPrep.DynamicProgramming;

/*
Given a string s, return the number of distinct non-empty subsequences of s. Since the answer may be very large, return it modulo 109 + 7.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not.



Example 1:

Input: s = "abc"
Output: 7
Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".

 */

import java.util.Arrays;

public class DistinctSubsequencesII {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        int n = s.length();

        // dp[i] = number of distinct subsequences ending at position i
        long[] dp = new long[n + 1];
        dp[0] = 1;  // Empty subsequence

        // last[c] stores the last position where character c was seen
        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Double the count (all previous subsequences + append current char)
            dp[i + 1] = (dp[i] * 2) % MOD;

            // If we've seen this character before, remove duplicates
            if (last[c - 'a'] >= 0) {
                // Subtract the subsequences that would be duplicated
                dp[i + 1] = (dp[i + 1] - dp[last[c - 'a']]) % MOD;
                if (dp[i + 1] < 0) dp[i + 1] += MOD;  // Handle negative modulo
            }

            last[c - 'a'] = i;  // Update the last position of this character
        }

        // Subtract 1 for the empty subsequence
        return (int)((dp[n] - 1 + MOD) % MOD);
    }
    public static void main(String[] args) {
        DistinctSubsequencesII distinctSubsequences = new DistinctSubsequencesII();
        System.out.println(distinctSubsequences.distinctSubseqII("abc"));
    }
}
