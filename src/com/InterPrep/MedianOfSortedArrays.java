package com.InterPrep;

import java.util.Arrays;

public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, m = nums1.length, n = nums2.length;
        if(m < 1 && n < 1) {
            return 0;
        }
        int start1 = 0, start2 = 0, end1 = m - 1, end2 = n - 1;
        return -1.0;
    }
    public static void main(String[] args) {
        MedianOfSortedArrays medianOfSortedArrays = new MedianOfSortedArrays();
        int[] nums1 = new int[]{1,3,6};
        int[] nums2 = new int[]{2,4,5};
        System.out.println(medianOfSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
