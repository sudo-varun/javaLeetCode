package com.InterPrep.Arrays;

import java.util.Arrays;

public class MergeDuplicate {
    public int merge(int[] nums) {
        int k = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        MergeDuplicate mergeDuplicate = new MergeDuplicate();
        int[] nums = {0,1,1,2};
        int k = mergeDuplicate.merge(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(k);
    }
}
