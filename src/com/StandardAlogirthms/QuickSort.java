package com.StandardAlogirthms;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }
    public void quickSortHelper(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = nums[right];
        int i = left, j = left;
        while(j < right) {
            if(nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        nums[j] = nums[i];
        nums[i] = pivot;

        quickSortHelper(nums, left, i - 1);
        quickSortHelper(nums, i + 1, right);
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {3,6,7,9,1,2,5};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
