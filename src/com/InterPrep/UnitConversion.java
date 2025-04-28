package com.InterPrep;

import java.util.Arrays;

/*
There are n types of units indexed from 0 to n - 1. You are given a 2D integer array conversions of length n - 1, where conversions[i] = [sourceUnit, targetUnit, conversionFactor]. This indicates that a single unit of type sourceUniti is equivalent to conversionFactori units of type targetUniti.

Return an array baseUnitConversion of length n, where baseUnitConversion[i] is the number of units of type i equivalent to a single unit of type 0. Since the answer may be large, return each baseUnitConversion[i] modulo 109 + 7.



Example 1:

Input: conversions = [[0,1,2],[1,2,3]]

Output: [1,2,6]

Explanation:

    Convert a single unit of type 0 into 2 units of type 1 using conversions[0].
    Convert a single unit of type 0 into 6 units of type 2 using conversions[0], then conversions[1].

Example 2:

Input: conversions = [[0,1,2],[0,2,3],[1,3,4],[1,4,5],[2,5,2],[4,6,3],[5,7,4]]

Output: [1,2,3,8,10,6,30,24]

Explanation:

    Convert a single unit of type 0 into 2 units of type 1 using conversions[0].
    Convert a single unit of type 0 into 3 units of type 2 using conversions[1].
    Convert a single unit of type 0 into 8 units of type 3 using conversions[0], then conversions[2].
    Convert a single unit of type 0 into 10 units of type 4 using conversions[0], then conversions[3].
    Convert a single unit of type 0 into 6 units of type 5 using conversions[1], then conversions[4].
    Convert a single unit of type 0 into 30 units of type 6 using conversions[0], conversions[3], then conversions[5].
    Convert a single unit of type 0 into 24 units of type 7 using conversions[1], conversions[4], then conversions[6].


 */
public class UnitConversion {
    public int[] baseUnitConversions(int[][] conversions) {
        long[] ans = new long[conversions.length+1];
        int mod = (int) Math.pow(10, 9) + 7;
        Arrays.fill(ans, -1);
        ans[0] = 1;
        for(int[] conversion: conversions) {
            int sourceUnit = conversion[0];
            int targetUnit = conversion[1];
            int factor = conversion[2];
            if(ans[sourceUnit] != -1) {
                ans[targetUnit] = (ans[sourceUnit] * factor) % mod;
            }
        }
        int[] res = new int[ans.length];
        for(int i = 0; i < ans.length; i++) {
            res[i] = ans[i] == -1 ? -1 : (int) ans[i];
        }
        return res;
    }
}
