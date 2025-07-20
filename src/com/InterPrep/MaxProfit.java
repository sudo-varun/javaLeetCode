package com.InterPrep;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxProfit {
    public int maxProfitOnlyOneBuy(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] <= minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    public int maxProfitCanSellImmediately(int[] prices) {
        int left = 0, right = 1;
        int totalProfit = 0;
        while(right < prices.length) {
            if(prices[left] < prices[right]) {
                totalProfit += prices[right] - prices[left];
            }
            left++;
            right++;
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfitCanSellImmediately(prices));
    }
}
