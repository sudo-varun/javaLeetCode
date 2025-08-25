package com.InterPrep.Greedy;

/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.



Example 1:

Input: nums = [10,2]
Output: "210"

Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"

 */

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> (b+a).compareTo(a+b));
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str);
        }
        return result.toString();
    }
    public int leftOrRight(int i, int j) {
        char[] a = Integer.toString(i).toCharArray();
        char[] b = Integer.toString(j).toCharArray();
        int aPointer = 0, bPointer = 0;
        while(aPointer < a.length && bPointer < b.length) {
            if(a[aPointer] != b[bPointer]) {
                return (int) a[aPointer] > (int) b[bPointer] ? i : j;
            }
            aPointer++;
            bPointer++;
        }
        if(aPointer < a.length) {
            if(a[aPointer] == '0') {
                return j;
            }
            return i;
        }
        if(bPointer < b.length) {
            if(b[bPointer] == '0') {
                return i;
            }
            return j;
        }
        return 0;
    }
    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.leftOrRight(10, 9));
    }
}
