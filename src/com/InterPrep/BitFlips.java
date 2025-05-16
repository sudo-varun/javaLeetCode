package com.InterPrep;

public class BitFlips {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int xor = start ^ goal;
        while(xor > 0) {
            count += xor & 1;
            xor >>= 1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(2 | 3 | 1);
    }
}
