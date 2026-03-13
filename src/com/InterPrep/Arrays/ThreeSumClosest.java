package com.InterPrep.Arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++) {
            int left = i + 1, right = n-1;
            while(left < right) {
                int curr = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - curr);
                if(diff < closest) {
                    ans = curr;
                    closest = diff;
                }
                if(target - curr < 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return ans;
    }
}
