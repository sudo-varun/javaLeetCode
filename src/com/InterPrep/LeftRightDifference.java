package com.InterPrep;

import java.util.Arrays;

/*

You are given a 0-indexed integer array nums of size n.

Define two arrays leftSum and rightSum where:

    leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
    rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.

Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.

 Example 1:

Input: nums = [10,4,8,3]
Output: [15,1,11,22]
Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
*/
public class LeftRightDifference {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSums = new int[n], rightSums = new int[n];
        leftSums[0] = 0;
        rightSums[n-1] = 0;
        for(int i = 1; i < n; i++) {
            leftSums[i] = leftSums[i-1] + nums[i-1];
            rightSums[n-1-i] = rightSums[n-i] + nums[n-i];
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = Math.abs(leftSums[i] - rightSums[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{10,4,8,3};
        LeftRightDifference leftRightDifference = new LeftRightDifference();
        System.out.println(Arrays.toString(leftRightDifference.leftRightDifference(nums)));
    }
}
