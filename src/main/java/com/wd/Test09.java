package com.wd;

import java.util.HashMap;

/**
 * 80.删除有序数组中的重复项II
 */
public class Test09 {
    public static void main(String[] args) {

    }

    /**
     * 双指针，计算一个重复次数
     * 重复次数达到了就换数据
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0 , j = 0;
        for ( ;j < nums.length;) {
            map.putIfAbsent(nums[j], 0);
            if (map.get(nums[j]) < 2){
                nums[i] = nums[j];
                map.put(nums[j],map.get(nums[j])+1);
                i++;
            }
            j++;
        }
        return i;
    }
}
