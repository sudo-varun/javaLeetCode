package com.InterPrep.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.



Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true
Example 3:

Input: s = "(]"

Output: false

     */

    public boolean isValid(String s) {
        Map<Character, Character> matches = new HashMap<>();
        matches.put('(', ')');
        matches.put('{', '}');
        matches.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()) {
            if(matches.containsKey(c)) {
                stack.add(c);
            } else {
                if(!stack.isEmpty() && c == matches.get(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
