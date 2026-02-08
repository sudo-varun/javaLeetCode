package com.InterPrep;


import java.util.Arrays;

public class ThirdMaximum {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums.length <= 3) return nums[n-1];
        return nums[n-3];
    }
}
