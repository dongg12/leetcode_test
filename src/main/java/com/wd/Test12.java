package com.wd;

/**
 * 121.买卖股票的最佳时机
 */
public class Test12 {
    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        maxProfit(arr);
    }

    /**
     * 先通过二分法找到最小值以及索引
     * 然后在索引右边找到最大值，相减完事
     * <p>
     * 二分法用不了，二分法需要用在有序的数组集合里面
     */
    public static int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;


    }
}
