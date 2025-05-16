package com.InterPrep;

public class LocalPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        if(nums[0] > nums[1]) {
            return 0;
        }
        if(nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int low = 1, high = nums.length - 2;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int leftElement = nums[mid - 1];
            int rightElement = nums[mid + 1];
            int elem = nums[mid];
            if(elem > leftElement && elem > rightElement) {
                return mid;
            }
            else if(elem < leftElement) {
                high = mid - 1;
            } else if(elem < rightElement) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
