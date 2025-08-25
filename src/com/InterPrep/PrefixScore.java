package com.InterPrep;

import java.util.Arrays;

public class PrefixScore {
    public long[] findPrefixScore(int[] nums) {
        int currMax = nums[0];

        long[] ans = new long[nums.length];
        ans[0] = nums[0] * 2;
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currMax = Math.max(currMax, num);
            int conversionArrayTerm = num + currMax;
            ans[i] = ans[i - 1] + conversionArrayTerm;
        }
        return ans;
    }
    public static void main(String[] args) {
        PrefixScore prefixScore = new PrefixScore();
        int[] nums = {2,3,7,5,10};
        long[] res = prefixScore.findPrefixScore(nums);
        System.out.println(Arrays.toString(res));
    }
}
