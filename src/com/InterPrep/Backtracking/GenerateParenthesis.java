package com.InterPrep.Backtracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), n, 0);
        return result;
    }
    private void backtrack(List<String> result, StringBuilder curr, int n, int stack) {
        if(n < 0 || stack < 0) {
            return;
        }
        if(n == 0 && stack == 0) {
            result.add(curr.toString());
        }
        curr = curr.append("(");
        backtrack(result, curr, n - 1, stack + 1);
        curr.deleteCharAt(curr.length() - 1);

        curr = curr.append(")");
        backtrack(result, curr, n, stack - 1);
        curr.deleteCharAt(curr.length() - 1);
    }
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}
