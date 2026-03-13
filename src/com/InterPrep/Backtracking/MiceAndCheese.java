package com.InterPrep.Backtracking;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MiceAndCheese {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0, n = reward1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diff);
        for(int i = 0; i < k; i++) {
            ans += diff[n - i - 1];
        }
        return ans;
    }
}
