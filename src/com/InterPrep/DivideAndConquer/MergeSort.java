package com.InterPrep.DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public int[] mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        divide(nums, 0, nums.length - 1, temp);
        return nums;
    }
    private void divide(int[] nums, int left, int right, int[] temp) {
        if(left >= right) {
            return;
        }
        int mid = left +(right - left) / 2;
        divide(nums, left, mid, temp);
        divide(nums, mid+1, right, temp);
        merge(nums, left, mid, right, temp);
    }
    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;       // Start of left subarray
        int j = mid + 1;    // Start of right subarray
        int k = left;       // Current position to fill in nums

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }
        while(i <= mid) {
            nums[k++] = temp[i++];
        }
    }
    public static void main(String[] args) {
        int[] input = new int[]{100, 99, 1, 88, 66, 22};
        MergeSort mergeSort = new MergeSort();
        int[] sorted = mergeSort.mergeSort(input);
        System.out.println(Arrays.toString(sorted));
    }
}
