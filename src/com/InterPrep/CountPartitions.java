package com.InterPrep;

import java.util.Arrays;

public class CountPartitions {
    public int countPartitions(int[] nums) {
        int n = nums.length;;
        int[] prefixSums = new int[n];
        prefixSums[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixSums[i] = prefixSums[i-1] + nums[i];
        }
        System.out.println(Arrays.toString(prefixSums));
        int count = 0;
        for(int i = 0; i < n - 1; i++) {
            int sumDiff = 2 *  prefixSums[i] - prefixSums[n-1];
            System.out.println(sumDiff);
            if(sumDiff % 2 == 0) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] input = new int[]{1,2,2};
        CountPartitions countPartitions = new CountPartitions();
        System.out.println(countPartitions.countPartitions(input));
    }
}
