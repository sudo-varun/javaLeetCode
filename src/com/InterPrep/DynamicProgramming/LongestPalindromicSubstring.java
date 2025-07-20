package com.InterPrep.DynamicProgramming;

/*
Given a string s, return the longest

in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        return s;
    }
    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s1 = "babad";
        String s2 = "cbbd";
        System.out.println(lps.longestPalindrome(s1)); // Output: "bab" or "aba"
        System.out.println(lps.longestPalindrome(s2)); // Output: "bb"
    }
}
