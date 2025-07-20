package com.InterPrep;

import java.util.Arrays;
import java.util.Collections;

public class DivideArrayMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 2;
        int n = nums.length;
        int[][] ans = new int[n/3][3];
        int counter = 0;
        while(right < nums.length) {
            int leftElement = nums[left];
            int rightElement = nums[right];
            int midElement = nums[left+1];
            if(
                    rightElement - leftElement > k
                    || rightElement - midElement > k
                    || midElement - leftElement > k
            ) {
                return new int[0][];
            }
            ans[counter] = new int[]{leftElement, midElement, rightElement};
            counter++;
            left += 3;
            right += 3;
        }
        return ans;
    }
    public static void main(String[] args) {
        DivideArrayMaxDifference divideArrayMaxDifference = new DivideArrayMaxDifference();
        int[] input = new int[]{4,3,4,1,9,1,1,6,5};
        int[][] ans = divideArrayMaxDifference.divideArray(input, 2);
        System.out.println(Arrays.deepToString(ans));
    }
}
