package com.InterPrep.Contest;

import java.util.HashSet;
import java.util.Set;

public class PartitionArray {
    long target;
    public boolean checkEqualPartitions(int[] nums, long target) {
        Set<Integer> numbers = new HashSet<>();
        for(int num: nums) {
            numbers.add(num);
        }
        this.target = target;
        return recurse(numbers, target, 2);
    }

    public boolean recurse(Set<Integer> nums, long target, int times) {
        if(target == 1) {
            times--;
            if(times == 0) return nums.isEmpty();
            target = this.target;
        }

        if(target < 1 || nums.isEmpty()) {
            return false;
        }
        for(int num: new HashSet<>(nums)) {  // Create a copy for iteration
            if(target % num != 0)
                continue;
            nums.remove(num);
            if(recurse(nums, target / num, times)) {
                return true;
            }
            nums.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionArray partitionArray = new PartitionArray();
        int[] nums = {3,1,6,8,4};
        int k = 24;
        System.out.println(partitionArray.checkEqualPartitions(nums, k)); // Output: true
    }
}
