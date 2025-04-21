package com.InterPrep;

import java.util.Arrays;

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
public class RandomPick {
    double[] freq;
    double[] prefixSum;
    public RandomPick(int[] w) {
        int sum = Arrays.stream(w).sum();
        freq = new double[w.length];
        for(int i = 0; i < w.length; i++) {
            freq[i] = (double) w[i] / sum;
        }
        prefixSum = new double[freq.length];

        prefixSum[0] = freq[0];
        for(int i = 1; i < freq.length; i++) {
            prefixSum[i] = prefixSum[i-1] + this.freq[i];
        }
    }

    public int pickIndex() {
        double rand = Math.random();
        int low = 0, high = prefixSum.length - 1;
        while(low < high) {
            int mid = (low + high)/2;
            if(prefixSum[mid] <= rand) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] w = new int[]{1,3};
        RandomPick randomPick = new RandomPick(w);
        System.out.println(randomPick.pickIndex());
    }


}
