package com.InterPrep;

public class CountValidSelections {
    public int countValidSelections(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int index = 0;
        for(int i = 0; i <= nums.length; i++) {
            leftSum += nums[i];
            if(nums[i] == 0) {
                index = i;
                break;
            }
        }
        for(int i = index; i < nums.length; i++) rightSum += nums[i];

        int count = 0;
        for(int i = index; i < nums.length; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];

            if (nums[i] != 0) continue;

            if(leftSum == rightSum) {
                count += 2;
            } else if (leftSum - 1 == rightSum || leftSum + 1 == rightSum) {
                count += 1;
            }

        }
        return count;
    }
}
