package com.InterPrep;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class ConvertArrayToZero {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (int a : nums) {
            while (!stack.isEmpty() && stack.peek() > a) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < a) {
                res++;
                stack.push(a);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 1, 2, 1, 2, 1};
        ConvertArrayToZero convertArrayToZero = new ConvertArrayToZero();
        System.out.println(convertArrayToZero.minOperations(input)); // Output: 5
    }
}