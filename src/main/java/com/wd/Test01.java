package com.wd;

/**
 * 1052.爱生气的老板
 */
public class Test01 {
    public static void main(String[] args) {
        int[] customers = {2,6,6,9};
        int[] grumpy = {0,0,1,1};
        int minutes = 1;

        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int length = customers.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
        }

        int temp = 0;
        for (int i = 0; i < length; i++) {
            int num = 0;
            for (int j = i; j < i + minutes && j < length; j++) {
                num += customers[j];
            }
            temp = Math.max(temp, num);
        }
        return sum + temp;

    }


    /**
     * 题解
     * 我们可以先将原本就满意的客户加入答案，同时将对应的 customers[i]customers[i]customers[i] 变为 000。
     *
     * 之后的问题转化为：在 customerscustomerscustomers 中找到连续一段长度为 minutesminutesminutes 的子数组，使得其总和最大。这部分就是我们应用技巧所得到的客户
     */
    public int maxSatisfiedV2(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length, ans = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
                customers[i] = 0;
            }
        }
        int cur = 0, max = 0;
        for (int i = 0; i < n; i++) {
            cur += customers[i];
            if (i >= minutes) cur -= customers[i - minutes];
            max = Math.max(max, cur);
        }
        return ans + max;
    }
}


