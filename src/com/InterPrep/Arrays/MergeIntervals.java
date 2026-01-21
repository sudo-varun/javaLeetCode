package com.InterPrep.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    /*
    Example 1:

    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // nlog(n)
        List<int[]> ans = new ArrayList<>();
        int[] curr = intervals[0];
        for(int i = 1; i < intervals.length; i++) {  // n
            int[] right = intervals[i];
            if(curr[1] >= right[0]) {
                curr[1] = Math.max(curr[1], right[1]);
            } else {
                ans.add(curr);
                curr = right;
            }
        }
        ans.add(curr);
        int[][] res = new int[ans.size()][2];
        int i = 0;
        for(int[] a: ans) { // n
            res[i] = a;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{15,18}, {4,7}, {1,4}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] ans = mergeIntervals.merge(intervals);
        System.out.println(Arrays.deepToString(ans));
    }
}
