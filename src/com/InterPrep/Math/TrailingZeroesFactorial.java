package com.InterPrep.Math;

public class TrailingZeroesFactorial {
    public int trailingZeroes(int n) {
        return n / 5 + n / 25 + n / 625 + n / 3125;
    }
}
