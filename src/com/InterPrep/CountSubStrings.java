package com.InterPrep;

public class CountSubStrings {
    public long countSubstrings(String s, char c) {
        long count = 0;
        for(char ch: s.toCharArray()) count += (ch == c)?1:0;
        return count * (count + 1)/2;
    }

    public static void main(String[] args) {
        String s = "abada";
        CountSubStrings countSubStrings = new CountSubStrings();
        System.out.println(countSubStrings.countSubstrings(s, 'a'));
    }
}
