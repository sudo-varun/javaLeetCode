package com.InterPrep;


public class MissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n*n + 1];
        for(int i = 0; i < n; i++) {
            for(int  j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }
        int[] ans = new int[2];
        boolean found = false;
        for(int value = 1; value < freq.length; value++) {
            if(freq[value] == 2) {
                ans[0] = value;
                if(found) break;
                found = true;
            } else if(freq[value] == 0) {
                ans[1] = value;
                if(found) break;
                found = true;
            }
        }
        return ans;
    }
}
