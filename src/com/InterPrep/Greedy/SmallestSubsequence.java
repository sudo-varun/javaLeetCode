package com.InterPrep.Greedy;

import java.util.*;

public class SmallestSubsequence {
    public String smallestSubsequence(String s) {
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(!seen.contains(c)) {
                while(!stack.isEmpty() && stack.peek() > c && lastOccurrence.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                stack.push(c);
                seen.add(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char c: stack) {
            ans.append(c);
        }
        return ans.toString();
    }
}
