package com.InterPrep;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubArraySum {
    public static void main(String[] args) {
        MinimumSubArraySum minimumSubArraySum = new MinimumSubArraySum();

        List<Integer> input = new ArrayList<>(List.of(-12, 8));

        System.out.println(minimumSubArraySum.minimumSumSubArray(input, 1,1));
    }
    public int minimumSumSubArray(List<Integer> nums, int l, int r) {
        int sum = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++) {
            int left = 0, right = i - 1;
            while(right < nums.size()) {
                int currSum = 0;
                for(int j = left; j <= right; j++) {
                    currSum += nums.get(j);
                }
                if(currSum > 0) {
                    sum = Math.min(currSum, sum);
                }
                left++;
                right++;
            }
        }
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }
}
