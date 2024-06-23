package com.wd;

/**
 * 238.除自身以外数组的乘积
 */
public class Test21 {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int[] leftSum = new int[nums.length];
        leftSum[0] = 1;
        int[] rightSum = new int[nums.length];
        rightSum[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = nums[i-1] * leftSum[i-1];
        }

        for (int j = nums.length- 2; j >=0; j--) {
            rightSum[j] = nums[j+1] * rightSum[j+1];
        }

        for (int i = 0; i < nums.length; i++) {
            leftSum[i] = leftSum[i] * rightSum[i];
        }
        return leftSum;
    }
}
