package com.wd;

/**
 * 189.轮转数组
 */
public class Test11 {
    public static void main(String[] args) {

    }

    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            rotate(nums);
        }
    }

    public void rotate(int[] nums) {
        int[] copyArr = new int[nums.length];
        System.arraycopy(nums, 0,  copyArr, 1, nums.length-1);
        copyArr[0] = nums[nums.length - 1];
        System.arraycopy(copyArr, 0,  nums, 0, nums.length);
    }

    /**
     * 直接把数组复制成两倍长度,右移k位就是从第n-k位往后的n个数字(n为数组长度)
     *
     * 注意k可能大于n,提前取余
     */
    public void rotateV2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] arr = new int[n << 1];
        System.arraycopy(nums, 0, arr, 0, n);
        System.arraycopy(nums, 0, arr, n, n);
        System.arraycopy(arr, n - k, nums, 0, n);
    }
}
