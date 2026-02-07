package com.InterPrep.Backtracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(new StringBuilder(), n, n, n, ans);
        return ans;
    }
    public void backtrack(StringBuilder curr, int target, int forward, int backward, List<String> ans) {
        if(curr.length() == target * 2) {
            ans.add(curr.toString());
            return;
        }
        if(forward > 0) {
            curr.append("(");
            backtrack(curr, target, forward - 1, backward, ans);
            curr.deleteCharAt(curr.length() - 1);
        }
        if(forward < backward) {

            curr.append(")");
            backtrack(curr, target, forward, backward - 1, ans);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}
