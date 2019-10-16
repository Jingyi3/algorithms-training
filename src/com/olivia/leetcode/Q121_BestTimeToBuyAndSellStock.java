package com.olivia.leetcode;

public class Q121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int profit = 0;
        int buyDay = 0;
        int sellDay = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[buyDay]) {
                profit = Math.max(profit, prices[i] - prices[buyDay]);
            } else if (prices[i] < prices[buyDay] && i != prices.length - 1) {
                buyDay = i;
            } else {
                return profit;
            }
        }
        return profit;
    }
}
