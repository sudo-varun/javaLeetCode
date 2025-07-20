package com.InterPrep.DynamicProgramming;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.



Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:

Input: triangle = [[-10]]
Output: -10

 */
public class Triangle {
    public int minimumTotal(@NotNull List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp =new int[n];
        for(int i=0;i<n;i++){
            dp[i]=triangle.get(n-1).get(i);
        }

        for(int i = n - 2; i >= 0; i--) {
            List<Integer> currRow = triangle.get(i);
            for(int j=0;j<=i;j++){
                dp[j] = currRow.get(j) + Math.min(dp[j], dp[j+1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        Triangle triangleObj = new Triangle();
        int result = triangleObj.minimumTotal(triangle);
        System.out.println(result);
    }
}
