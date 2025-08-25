package com.InterPrep;

public class ReverseDegreeString {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            ans += ('z' - s.charAt(i) + 1) * (i + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        ReverseDegreeString revDegreeStr = new ReverseDegreeString();
        System.out.println(revDegreeStr.reverseDegree("zaza"));
    }
}
