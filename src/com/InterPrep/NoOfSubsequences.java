package com.InterPrep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NoOfSubsequences {
    public static void main(String[] args) {
        int[] input = new int[]{3,4,3,4,3,4,3,4};
        NoOfSubsequences noOfSubsequences = new NoOfSubsequences();
        System.out.println(noOfSubsequences.numberOfSubsequences(input));
    }
    public long numberOfSubsequences(int[] nums) {
        int count = 0;
        Set<String> sequences = new HashSet<>();
        for(int p = 0; p < nums.length; p++) {
            for(int q = p+1; q < nums.length; q++) {
                if(q - p <= 1) {
                    continue;
                }
                for(int r = q+1; r < nums.length; r++) {
                    if(r - q <= 1) {
                        continue;
                    }
                    for(int s = r+1; s < nums.length; s++) {
                        if(s - r <= 1) {
                            continue;
                        }
                        if(nums[p] * nums[r] == nums[q] * nums[s]) {
                            Integer[] currentSubsequence = new Integer[]{nums[p], nums[q], nums[r], nums[s]};
                            if(!sequences.contains(Arrays.toString(currentSubsequence))) {
                                System.out.println("Subsequence found: " + Arrays.toString(currentSubsequence));
                                sequences.add(Arrays.toString(currentSubsequence));
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
