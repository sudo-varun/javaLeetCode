package com.InterPrep;

public class RangeBitwise {
    public int rangeBitwiseAnd(int left, int right) {
        int[] leftBits = new int[32];
        int[] rightBits = new int[32];
        int index = 0;
        while (left > 0 || right > 0) {
            leftBits[index] = left % 2;
            rightBits[index] = right % 2;
            left /= 2;
            right /= 2;
            index++;
        }
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if (leftBits[i] == rightBits[i]) {
                result += (int) (leftBits[i] * Math.pow(2, i));
            } else {
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(1 & 0);
    }
}
