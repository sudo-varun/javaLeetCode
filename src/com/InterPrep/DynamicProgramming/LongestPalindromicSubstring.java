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
        if(s.isEmpty()) return "";
        int longestLen = 0;
        String ans = "";
        int n = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < n; i++) {
            // odd
            int left = i, right = i;
            while(left >= 0 && right < n && c[left] == c[right]) {
                if(right - left + 1 > longestLen) {
                    ans = s.substring(left, right + 1);
                    longestLen = right - left + 1;
                }
                left--;
                right++;
            }
            // even
            left = i;
            right = i + 1;
            while(left >= 0 && right < n && c[left] == c[right]) {
                if(right - left + 1 > longestLen) {
                    ans = s.substring(left, right + 1);
                    longestLen = right - left + 1;
                }
                left--;
                right++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s1 = "ac";
        String s2 = "abbcccba";
        System.out.println(lps.longestPalindrome(s1)); // Output: "bab" or "aba"
        System.out.println(lps.longestPalindrome(s2)); // Output: "bb"
    }
}
