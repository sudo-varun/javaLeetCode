package com.InterPrep;

import java.util.Arrays;

public class ZeroArray {

    public static void main(String[] args) {
        ZeroArray zeroArray = new ZeroArray();
        int[] nums = {2, 3, 4, 5};
        int[][] queries = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(zeroArray.isZeroArray(nums, queries)); // Output: false
    }
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] freq = new int[n];

        for(int[] q : queries) {
            freq[q[0]]++;
            if(q[1] + 1 < n) {
                freq[q[1] + 1]--;
            }
        }
        System.out.println(Arrays.toString(freq));
        int curFreq = 0;
        for(int i = 0; i < n; i++) {
            curFreq += freq[i];
            if(curFreq < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
