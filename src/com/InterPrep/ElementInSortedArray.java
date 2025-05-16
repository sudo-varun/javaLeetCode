package com.InterPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        result[0] = left;
        result[1] = right;
        return result;
    }

    private int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                idx = mid;
                if (isSearchingLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return idx;
    }
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3};
        ElementInSortedArray elementInSortedArray = new ElementInSortedArray();
        int[] ans = elementInSortedArray.searchRange(input, 1);
        System.out.println(Arrays.toString(ans));
    }
}
