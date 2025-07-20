package com.InterPrep;

import java.util.Arrays;

/*
Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.

Return the shortest such subarray and output its length.



Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Example 2:

Input: nums = [1,2,3,4]
Output: 0

Example 3:

Input: nums = [1]
Output: 0

 */
public class LongestUnsortedSubArray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        // Find the first out-of-order element from the left
        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        // If the array is already sorted
        if (left == n - 1) {
            return 0;
        }

        // Find the first out-of-order element from the right
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }

        // Find the min and max in the unsorted subarray
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Expand the boundaries to include all elements that need sorting
        while (left > 0 && nums[left - 1] > min) {
            left--;
        }
        while (right < n - 1 && nums[right + 1] < max) {
            right++;
        }

        return right - left + 1;
    }
    public static void main(String[] args) {
        int[] input = {1,3,2,2,2};
        LongestUnsortedSubArray longestUnsortedSubArray = new LongestUnsortedSubArray();
        System.out.println(longestUnsortedSubArray.findUnsortedSubarray(input));
    }
}
