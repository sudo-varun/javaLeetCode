package com.InterPrep.BinarySearch;

public class HIndexII {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int h = 0;
        int left = 0, right = n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int cit = citations[mid];
            if(n - mid == cit) {
                return n-mid;
            }
            if(n - mid > cit) {
                h = Math.min(cit, h);
                left = mid + 1;
            } else {
                h = Math.max(h, cit);
                right = mid - 1;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        int[] citations = {100};
        HIndexII hIndexII = new HIndexII();
        System.out.println(hIndexII.hIndex(citations));
    }
}
