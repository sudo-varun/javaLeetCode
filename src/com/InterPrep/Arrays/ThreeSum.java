package com.InterPrep.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n-2; i++) {
            if(i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int curr = nums[i];
            int left = i + 1, right = n - 1;
            while(left < right) {
                int currSum = curr + nums[left] + nums[right];
                if(currSum == 0) {
                    res.add(Arrays.asList(curr, nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
                if(currSum < 0) {
                    left++;
                }
                if(currSum > 0) {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum.threeSum(nums));
    }
}
