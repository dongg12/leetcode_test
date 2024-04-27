package com.wd;

import java.time.temporal.ValueRange;

/**
 * 27.移除元素
 */
public class Test06 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
        System.out.println();
    }

    public static int removeElement(int[] nums, int val) {
        int count = nums.length;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != val) { //不相等，才交换
                nums[i] = nums[j];
                i++;

            }else {
                count--;
            }
            j++;
        }

        for (int k = i; k < nums.length; k++) {
            nums[k] = 0;
        }
        return count;
    }
}
