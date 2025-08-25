package com.InterPrep;

public class ReverseInteger {
    public int reverse(int x) {
        int ans = 0;
        boolean negative = x < 0;
        x = Math.abs(x);
        while(x > 0) {
            ans = ans * 10 + (x % 10);
            x /= 10;
        }
        return negative ? -ans : ans;
    }

}
