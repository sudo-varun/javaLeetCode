package com.InterPrep;

import java.util.ArrayList;
import java.util.List;
/*
You are given a 0-indexed integer array nums. In one step, remove all elements nums[i] where nums[i - 1] > nums[i] for all 0 < i < nums.length.

Return the number of steps performed until nums becomes a non-decreasing array.



Example 1:

Input: nums = [5,3,4,4,7,3,6,11,8,5,11]
Output: 3
Explanation: The following are the steps performed:
- Step 1: [5,3,4,4,7,3,6,11,8,5,11] becomes [5,4,4,7,6,11,11]
- Step 2: [5,4,4,7,6,11,11] becomes [5,4,7,11,11]
- Step 3: [5,4,7,11,11] becomes [5,7,11,11]
[5,7,11,11] is a non-decreasing array. Therefore, we return 3.

Example 2:

Input: nums = [4,5,7,7,13]
Output: 0
Explanation: nums is already a non-decreasing array. Therefore, we return 0.
Input: [10,1,2,3,4,5,6,1,2,3]
Output: 6
 */

public class StepsToMakeNonDecreasing {
    public static void main(String[] args) {
        StepsToMakeNonDecreasing stepsToMakeNonDecreasing = new StepsToMakeNonDecreasing();
        int[] input = new int[]{10,1,2,3,4,5,6,1,2,3};
        System.out.println(stepsToMakeNonDecreasing.totalSteps(input));
    }
    public int totalSteps(int[] nums) {
        int maxDistance = 0, currMax = nums[0], currMaxIdx = 0;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        for(int i = 1; i < nums.length; i++) {
            if(currMax > nums[i]) {
                dp[i] = i - currMaxIdx;
            }else {
                currMax = nums[i];
                currMaxIdx = i;
            }

        }
        System.out.println(maxDistance);
//        return globalMax;
        return maxDistance;
    }
}
