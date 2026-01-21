package com.StandardAlogirthms;

import java.util.Arrays;

public class InsertSort {

    public void insertSort(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            int currPosition = i;
            while(currPosition > 0 && nums[currPosition - 1] > nums[currPosition]) {
                swap(nums, currPosition, currPosition - 1);
                currPosition--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] nums = {161, 83, 371, 233, 926, 345, 23};
        insertSort.insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
