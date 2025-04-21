package com.InterPrep;

import java.util.*;

public class SmallestLexicographicalPalindrome {
    public static void main(String[] args) {
        String s = "babab";
        SmallestLexicographicalPalindrome slp = new SmallestLexicographicalPalindrome();
        System.out.println(slp.smallestPalindrome(s));
    }
    public String smallestPalindrome(String s) {
        int n = s.length();

        char[] charArray = new char[n/2 + 1];
        for (int i = 0; i <= n/2; i++) {
            charArray[i] = s.charAt(i);
        }
        Arrays.sort(charArray);

        char middleLetter = n % 2 == 1 ? s.charAt(n / 2) : '\0';

        // Create a reversed copy of charArray
        char[] reversedCharArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            reversedCharArray[i] = charArray[charArray.length - 1 - i];
        }

        String result;
        if(middleLetter != '\0')  return String.valueOf(charArray) + middleLetter + String.valueOf(reversedCharArray);
        return String.valueOf(charArray) + String.valueOf(reversedCharArray);
    }
}
