package com.olivia.leetcode;

public class Q122_BestTimetoBuyandSellStockII {
    public int maxProfitII(int[] prices) {

        if (prices == null || prices.length < 2) return 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
}
