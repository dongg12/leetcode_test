package com.wd;

/**
 * 45.跳跃游戏II
 */
public class Test18 {
    public static void main(String[] args) {

    }

    /**
     * 正向遍历
     * 记录每一次能够跳的最远距离
     */
    public int jump(int[] nums) {
        int step = 0;
        int position = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (end >= nums.length-1){
                break;
            }
            if (position >= nums.length-1){
                return step++;
            }
            // 这一次跳的最远距离
            position = Math.max(nums[i] + i, position);
            if (end == i){
                step++;
                end = position;
            }
        }
        return step;
    }
}
