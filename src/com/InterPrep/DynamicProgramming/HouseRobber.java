package com.InterPrep.DynamicProgramming;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int maxProfit = 0, prevProfit = 0;
        for(int num: nums) {
            int temp = Math.max(prevProfit + num, maxProfit);
            prevProfit = maxProfit;
            maxProfit = temp;
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] houses = new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.println(houseRobber.rob(houses));
    }
}
