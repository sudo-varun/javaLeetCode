package com.InterPrep.Stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path.isEmpty()) return path;
        Stack<String> ans = new Stack<>();
        for(String s: path.split("/")) {
            if(s.isEmpty() || s.equals(".")) continue;
            if(s.equals("..")) {
                if(!ans.isEmpty()) ans.pop();
                continue;
            }
            ans.add(s);
        }
        if(ans.isEmpty()) return "/";
        System.out.println(ans);
        StringBuilder res = new StringBuilder();
        for(String s: ans.reversed()) {
            res.append("/");
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        String path = "/a/./b/../../c/";
        System.out.println(simplifyPath.simplifyPath(path));

    }
}
