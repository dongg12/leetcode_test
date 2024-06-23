package com.wd;

/**
 * 135.分发糖果
 */
public class Test23 {
    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        int[] rightArr = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]){
                rightArr[i] = rightArr[i - 1] + 1;
            }else {
                rightArr[i] = 1;
            }
        }

        int right = 0;
        int sum = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i]> ratings[i + 1]){
                right++;
            }else {
                right = 1;
            }
            sum += Math.max(rightArr[i],right);
        }
        return sum;
    }
}
