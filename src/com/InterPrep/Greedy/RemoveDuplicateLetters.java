package com.InterPrep.Greedy;

import java.util.*;

public class RemoveDuplicateLetters {
    /*
    Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your
    result is the smallest in lexicographically order among all possible results.

    Example 1:

    Input: s = "bcabc"
    Output: "abc"

    Example 2:

    Input: s = "cbacdcbc"
    Output: "acdb"

    Constraints:

    1 <= s.length <= 104
    s consists of lowercase English letters.

     */
    public String removeDuplicateLetters(String s) {
        int[] lastOccurrence = new int[26];
        for(int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        Set<Character> seen = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!seen.contains(c)) {
                while(!stack.isEmpty() && c < stack.peek() && i < lastOccurrence[stack.peek() - 'a']) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("cbacdcbc"));
    }
}
