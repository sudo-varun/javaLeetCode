package com.InterPrep.DynamicProgramming;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length() - 1]  = true;
        Set <String> wordSet = new HashSet<>(wordDict);
        for(int i = 1; i < s.length(); i++) {
            for(int j = 0; j < i + 1; j++) {
                if(dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if we found a valid word
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat");
        String s = "catsandog";
        System.out.println(wordBreak.wordBreak(s, wordDict)); // Output: true
    }
}
