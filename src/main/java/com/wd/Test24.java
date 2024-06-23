package com.wd;

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;

public class Test24 {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int[] leftArr = new int[height.length];
        int[] rightArr = new int[height.length];

        leftArr[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftArr[i] = Math.max(height[i - 1], leftArr[i - 1]);
        }

        rightArr[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightArr[i] = Math.max(height[i + 1], rightArr[i + 1]);
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (Math.min(leftArr[i], rightArr[i]) - height[i] > 0){
                sum +=Math.min(leftArr[i], rightArr[i]) - height[i];
            }


        }
        return sum;

    }
}
