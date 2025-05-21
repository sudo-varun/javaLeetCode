package com.InterPrep.Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    Map<Character, char[]> digitToChar;
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        digitToChar = Map.of(
                '2', new char[]{'a', 'b', 'c'},
                '3', new char[]{'d', 'e', 'f'},
                '4', new char[]{'g', 'h', 'i'},
                '5', new char[]{'j', 'k', 'l'},
                '6', new char[]{'m', 'n', 'o'},
                '7', new char[]{'p', 'q', 'r', 's'},
                '8', new char[]{'t', 'u', 'v'},
                '9', new char[]{'w', 'x', 'y', 'z'}
        );
        List<String> ans = new ArrayList<>();
        backtrack("", digits, ans, 0);
        return ans;
    }
    public void backtrack(String currString, String digits, List<String> ans, int index) {
        if(currString.length() == digits.length()) {
            ans.add(currString);
            return;
        }
        char currentDigit = digits.charAt(index);
        char[] currentChars = digitToChar.get(currentDigit);
        for(char c: currentChars) {
            backtrack(currString + c, digits, ans, index + 1);
        }
    }
    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("92"));
    }
}
