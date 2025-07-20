package com.InterPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayPowers {
    public int[] resultsArray(int[] nums, int k) {
        if(k == 1) {
            return nums;
        }
        int consecutive = 1;
        int n = nums.length;
        int[] results = new int[n - k + 1];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == 1) {
                consecutive++;
            }else {
                consecutive = 1;
            }
            if(i >= k - 1) {
                results[i-k+1] = consecutive >= k ? nums[i] : -1;
            }
        }
        return results;
    }
    // [52,12,13,14]
    // [52,-1,13,14]

    // tle solution brute force
//    public int[] resultsArray(int[] nums, int k) {
//        List<Integer> res = new ArrayList<>();
//        int right = k - 1, left = 0;
//
//        while(right < nums.length) {
//            int power = -1;
//            for(int i = left + 1; i <= right; i++) {
//                if(nums[i] - nums[i-1] != 1) {
//                    power = -1;
//                    break;
//                }
//                power = nums[i];
//            }
//            res.add(power);
//            right++;
//            left++;
//        }
//        return res.stream().mapToInt(Integer::intValue).toArray();
//    }
    public static void main(String[] args) {
        int[] input = {1,2,3,4,3,2,5};
        SubArrayPowers subArrayPowers = new SubArrayPowers();
        int[] ans = subArrayPowers.resultsArray(input, 3);
        System.out.println(Arrays.toString(ans));
    }
}
