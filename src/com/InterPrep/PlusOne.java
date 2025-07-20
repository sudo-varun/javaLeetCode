package com.InterPrep;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;;
        int[] result = new int[n + 1];
        int carry = 0;
        System.out.println((digits[n-1] + 1) / 10);
        result[n-1] = (digits[n-1] + 1) % 10;
        carry = (digits[n-1] + 1) / 10;
        digits[n-1] = (digits[n-1] + 1) % 10;
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(digits));
        System.out.println(carry);
        for(int i = n - 2; i >= 0; i--) {
            result[i] = (digits[i] + carry) % 10;
            int tempCarry = (digits[i] + carry) / 10;
            digits[i] = (digits[i] + carry) % 10;
            carry = tempCarry;
        }
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(digits));
        System.out.println(carry);
        if(carry == 0) {
            return digits;
        }
        result[0] = carry;
        return result;
    }
    public static void main(String[] args) {
        int[] input = new int[]{8,9,9,9};
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(input)));
    }
}
