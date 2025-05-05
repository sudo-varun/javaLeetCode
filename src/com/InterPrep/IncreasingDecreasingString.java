package com.InterPrep;

import java.util.PriorityQueue;

public class IncreasingDecreasingString {
    public String sortString(String s) {
        StringBuilder ans = new StringBuilder();
        int[] freq = new int[26];
        int totalChars = s.length();
        for(char c: s.toCharArray()) {
            freq[c-'a']++;
        }
        while(totalChars > 0) {
            for(int i = 0; i < 26; i++) {
                if(freq[i] > 0) {
                    ans.append(Character.toChars('a' + i));
                    freq[i]--;
                    totalChars--;
                }
            }
            for(int i = 25; i >= 0; i--) {
                if(freq[i] > 0) {
                    ans.append(Character.toChars('a' + i));
                    freq[i]--;
                    totalChars--;
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String input = "rat";
        IncreasingDecreasingString increasingDecreasingString = new IncreasingDecreasingString();
        System.out.println(increasingDecreasingString.sortString(input));
    }
}
