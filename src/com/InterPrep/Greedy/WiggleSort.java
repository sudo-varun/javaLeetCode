package com.InterPrep.Greedy;

import java.util.Arrays;

/*
    Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

    You may assume the input array always has a valid answer.



    Example 1:

    Input: nums = [1,5,1,1,6,4]
    Output: [1,6,1,5,1,4]
    Explanation: [1,4,1,5,1,6] is also accepted.

    Example 2:

    Input: nums = [1,3,2,2,3,1]
    Output: [2,3,1,3,1,2]
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int[] positions = new int[5001];
        for(int num: nums) {
            positions[num]++;
        }
        int index = 1;
        for(int i = 5000; i >= 0; i--) {
            while(positions[i] > 0) {
                nums[index] = i;
                index += 2;
                positions[i]--;
            }
            if(index > nums.length) index = 0;
        }
    }
    public static void main(String[] args) {
        WiggleSort wiggleSort = new WiggleSort();
        int[] nums = {1,5,1,1,6,4};
        wiggleSort.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
