package com.InterPrep;

import java.util.Arrays;
//[4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
public class MaximumORSubArray {
    public int[] smallestSubarrays(int[] nums) {
        int[] nearest = new int[32];
        int[] ans = new int[nums.length];
        int n = nums.length;
        Arrays.fill(nearest, -1);
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j < 32; j++) {
                if((nums[i] & (1 << j)) != 0) {
                    nearest[j] = i;
                }
            }

            int lastELementSet = i;
            for(int j = 0; j < 32; j++) {
                lastELementSet = Math.max(lastELementSet, nearest[j]);
            }
            ans[i] = lastELementSet - i + 1;
        }
        return ans;
    }
}
