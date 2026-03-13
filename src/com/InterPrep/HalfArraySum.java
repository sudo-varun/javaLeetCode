package com.InterPrep;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class HalfArraySum {
    public int halveArray(int[] nums) {
        int n = nums.length;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double arraySum = 0;
        for (int num: nums) {
            pq.offer(((double) num));
            arraySum += num;
        }

        double currSum = arraySum;
        int operations = 0;
        while(currSum > arraySum / 2) {
            double currHighest = pq.poll();
            double newEl = currHighest / 2;
            currSum -= newEl;
            pq.offer(newEl);
            operations++;
        }
        return operations;
    }

    public static void main(String[] args) {
        int[] nums = {3,8,20};
        HalfArraySum halfArraySum = new HalfArraySum();
        System.out.println(halfArraySum.halveArray(nums));
    }
}
