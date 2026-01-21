package com.InterPrep.DivideAndConquer;

import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        int right = 0, n = nums.length;
        while(right < n) {
            currSum += nums[right];
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0) {
                currSum = 0;
            }
            right++;
        }
        return maxSum;
    }
    int maxSum = Integer.MIN_VALUE;
    public int maxSubArraySum(int[] nums) {
        maxSumHelper(nums, 0, nums.length - 1);
        return maxSum;
    }
    public int maxSumHelper(int[] nums, int left, int right) {
        if(left >= right) {
            maxSum = Math.max(maxSum, nums[left]);
            return nums[left];
        }
        int maxSum;
        if(nums[left] > nums[right]) {
            maxSum = nums[left] + maxSumHelper(nums, left + 1, right);
        } else {
            maxSum = nums[right] + maxSumHelper(nums, left, right - 1);
        }
        this.maxSum = Math.max(this.maxSum, maxSum);
        return maxSum;
    }
}
