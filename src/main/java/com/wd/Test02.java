package com.wd;

import javax.sound.midi.Soundbank;

/**
 * 滑动窗口，指定长度求和
 */
public class Test02 {
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        querySum(arr, 1);
    }

    public static void querySum(int[] arr,int length){
        int n = arr.length;
        int sum = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (i >= length){
                sum = sum - arr[i - length];
            }
            System.out.println(sum);
            cur = Math.max(sum, cur);
        }
        System.out.println(cur);
    }
}
