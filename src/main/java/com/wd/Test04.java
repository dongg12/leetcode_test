package com.wd;

import java.util.Arrays;

/**
 * 88.合并两个有序数组
 */
public class Test04 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 6;
        int n = 3;
        merge(nums1,m,nums2,n);
        System.out.println(nums1);
    }

    /**
     * 新建数组
     * 依次对比每个数据，小的放前面
     * 如果一个数组比到头了，循环遍历另一个数组数据放入新数组里面
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < m || index2 < n) {
            if (index1 == m) {
                arr[index] = nums2[index2++];
            } else if (index2 == n) {
                arr[index] = nums1[index1++];
            } else if (nums1[index1] < nums2[index2]) {
                arr[index] = nums1[index1++];
            } else {
                arr[index] = nums2[index2++];
            }
            index++;
        }
        if (arr.length >= 0) System.arraycopy(arr, 0, nums1, 0, arr.length);
    }
}
