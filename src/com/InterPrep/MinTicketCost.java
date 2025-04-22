package com.InterPrep;

public class MinTicketCost {
    public int minCostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        return dfs(days, costs, 0, 0, dp);
    }
    private int dfs(int[] days, int[] costs, int i, int validity, int[] dp) {
        if(i== days.length) {
            return 0;
        }
        if(dp[i] != 0) {
            return dp[i];
        }
        if(days[i] < validity) {
            return dfs(days, costs, i+1, validity, dp);
        }
        int oneDayCost = costs[0] + dfs(days, costs, i+1, days[i] + 1, dp);
        int oneWeekCost = costs[1] + dfs(days, costs, i+1, days[i] + 7, dp);
        int oneMonthCost = costs[2] + dfs(days, costs, i+1, days[i] + 30, dp);
        dp[i] =  Math.min(oneDayCost, Math.min(oneWeekCost, oneMonthCost));
        return dp[i];
    }
}
