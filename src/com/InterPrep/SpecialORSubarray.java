package com.InterPrep;

public class SpecialORSubarray {
    public int minimumSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0, currOr = nums[left];
        int minLen = Integer.MAX_VALUE;
        while(right < nums.length) {
            if(nums[right] >= k) return 1;
            currOr |= nums[right];
            System.out.println("curr OR: " + currOr);
            if(currOr >= k) {
                System.out.println("Curr Or > k: left = " + left + " right = " + right);
                minLen = Math.min(minLen, right - left + 1);
                left++;
                currOr = nums[left];
                right = left;
            } else {
                right++;
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,11,15,13,32};
        SpecialORSubarray specialORSubarray = new SpecialORSubarray();
        System.out.println(specialORSubarray.minimumSubarrayLength(nums, 34));
    }
}
