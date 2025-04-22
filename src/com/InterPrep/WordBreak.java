package com.InterPrep;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[wordDict.size() + 1];
        dp[wordDict.size()] = true;
        for(int i = wordDict.size() - 1; i >= 0; i--) {
            for(String word: wordDict) {
               if((i + word.length() < s.length()) && s.startsWith(word, i)) {
                   dp[i] = dp[i + word.length()];
               }
               if(dp[i]) {
                   break;
               }
            }
        }
        return dp[0];
    }
}

// [0,0,0,0,0]