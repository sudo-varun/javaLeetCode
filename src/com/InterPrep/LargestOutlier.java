package com.InterPrep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestOutlier {
    public static void main(String[] args) {
        // use this as input [6,-31,50,-35,41,37,-42,13]
        int[] nums = new int[]{6,-31,50,-35,41,37,-42,13};
        LargestOutlier largestOutlier = new LargestOutlier();
        System.out.println(largestOutlier.getLargestOutlier(nums));
    }
    public int getLargestOutlier(int[] nums) {
        int sumNums = 0;
        Map<Integer, Integer> integers = new HashMap<>();
        for(int num:nums) {
            integers.putIfAbsent(num, integers.getOrDefault(num, 0) + 1);
            sumNums+=num;
        }
        int currOutlier = Integer.MIN_VALUE;
        for(int num: nums) {
            int possibleOutlier = sumNums - 2 * num;
            if (integers.getOrDefault(possibleOutlier, 0) > (possibleOutlier == num ? 1 : 0)) {
                currOutlier = Math.max(currOutlier, possibleOutlier);
            }
        }
        return currOutlier;
    }
}
