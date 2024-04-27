package com.wd;

/**
 * 26.删除有序数组重复项
 */
public class Test08 {
    public static void main(String[] args) {

    }

    /**
     * 如果相等,快指针++
     * 如果不等，快慢指针都要++，但是要考虑快指针比慢指针走快好几步了
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int count = nums.length;
        for (int i = 0, j = 1; j < nums.length; ) {
            if (nums[i] != nums[j]) {
                if (j - i > 1) {
                    nums[i + 1] = nums[j];
                }
                i++;
            } else {
                count--;
            }
            j++;
        }
        return count;
    }
}
