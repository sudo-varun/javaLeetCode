package com.InterPrep;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] numsCopy = Arrays.copyOf(nums, n);
        k = k % n;
        for(int i = 0; i < n; i++) {
            nums[(i + k) % n] = numsCopy[i];
        }
    }
    public static void main(String[] args) {
        int[] input = {-1,-100,3,99};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(input, 2);
        System.out.println(Arrays.toString(input));
    }
}
