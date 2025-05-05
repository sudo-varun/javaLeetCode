package com.InterPrep;

public class MiddleIndexArray {
    public int findMiddleIndex(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int n = nums.length;
        int[] rightSum = new int[n];
        rightSum[n-1] = 0;
        rightSum[n-2] = nums[n-1];
        for(int i = 3; i < nums.length; i++) {
            rightSum[n-i] = rightSum[n-i-2] + nums[n-i-1];
        }
        int leftSum = 0;
        for(int i =1; i < nums.length; i++) {
            leftSum += nums[i];
            if(leftSum == rightSum[i]) {
                return i;
            }
        }
        return -1;
    }
}
