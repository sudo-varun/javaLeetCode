package com.InterPrep;

import java.util.Arrays;

public class PivotInteger {
    public int pivotInteger(int n) {
        int ans = n;
        int[] prefixSum = new int[n+1];
        prefixSum[0] = 0;
        for(int i = 2; i <= n; i++) {
            prefixSum[i - 1] = prefixSum[i-2] + i;
        }
        System.out.println(Arrays.toString(prefixSum));
        int currSum = 0;
        for(;ans >= 0; ans--) {
            currSum += ans;
            if(currSum == prefixSum[ans]) {
                break;
            }
        }
        return ans;
    }
}
