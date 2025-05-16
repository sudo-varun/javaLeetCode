package com.InterPrep;

import java.util.Arrays;

public class SpecialArray {
    public int specialArray(int[] nums) {
        if(nums.length == 0) {
            return nums.length;
        }
        for(int i = 1; i < 100; i++) {
            int greaterAndEqual = 0;
            for(int num: nums) {
                if(num >= i) {
                    greaterAndEqual++;
                }
            }
            if(greaterAndEqual == i) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] input = new int[]{0,4,3,0,4};
        SpecialArray specialArray = new SpecialArray();
        System.out.println(specialArray.specialArray(input));
    }
}
