package com.InterPrep.Math;

public class TrailingZeroesFactorial {
    public int trailingZeroes(int n) {
        return n / 5 + n / 25 + n/125 +  n / 625 + n / 3125;
    }

    public static void main(String[] args) {
        TrailingZeroesFactorial tz = new TrailingZeroesFactorial();
        System.out.println(tz.trailingZeroes(10000));
    }
}
