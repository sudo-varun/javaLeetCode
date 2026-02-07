package com.InterPrep.HashMap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    /**
     * Given a string s, find the length of the longest
     * without duplicate characters.

     * Example 1:
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

     * Example 2:

     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.

     * Example 3:

     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public int lengthOfLongestSubstring(String s) {
        int longest = 0, left = 0;
        Map<Character, Integer> lastPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(lastPos.containsKey(c)) {
                left = lastPos.get(c) + 1;
            }
            lastPos.put(c, i);
            longest = Math.max(longest, i - left + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring("dvdf"));
    }
}
