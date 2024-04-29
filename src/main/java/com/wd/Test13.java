package com.wd;

/**
 * 122.买卖股票的最佳时机II
 */
public class Test13 {
    public static void main(String[] args) {

    }


    /**
     * 如果上涨就累加起来
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]){
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }
}
