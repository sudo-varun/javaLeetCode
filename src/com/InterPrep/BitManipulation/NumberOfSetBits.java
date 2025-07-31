package com.InterPrep.BitManipulation;

public class NumberOfSetBits {
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    public static void main(String[] args) {
        NumberOfSetBits numberOfSetBits = new NumberOfSetBits();
        int input = 11; // Example input: binary representation is 1011
        int result = numberOfSetBits.hammingWeight(input);
        System.out.println("Number of set bits: " + result);
    }
}
