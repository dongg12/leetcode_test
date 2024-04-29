package com.wd;

/**
 * 55.跳跃游戏
 */
public class Test14 {
    public static void main(String[] args) {

    }

    /**
     * 从前往后依次判断
     * 先初始化第一个位置，第一个位置是可以跳的
     * 如果这个位置可以跳，才进行依次遍历
     */
    public boolean canJump(int[] nums) {
        boolean[] boo = new boolean[nums.length];
        boo[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (boo[i]){
                for (int j = 1; j <= nums[i] && i + j <nums.length; j++) {
                    boo[i + j] = true;
                }
            }
        }

        return boo[nums.length - 1];
    }

    /**
     * 如果你遍历的位置，最远到达的地方，都到不了，那最后那个位置肯定也到不了
     */
    public boolean canJumpV2(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach){
                return false;
            }else {
                reach = Math.max(reach, i+nums[i]);
            }
        }
        return true;

    }
}
