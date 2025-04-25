package com.InterPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumericallySmallestString {
    public static void main(String[] args) {
        NumericallySmallestString numericallySmallestString = new NumericallySmallestString();
        System.out.println(numericallySmallestString.getSmallestString(85, 2159));
    }
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        k -= n;
        while(k > 0) {
            ans[--n] += Math.min(25, k);
            k -= Math.min(25, k);
        }
        return String.valueOf(ans);
    }
}
