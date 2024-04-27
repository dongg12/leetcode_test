package com.wd;

import java.util.HashMap;

/**
 * 169.多数元素
 */
public class Test10 {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i],map.get(nums[i])+1);
            if (map.get(nums[i]) > length/2){
                return nums[i];
            }
        }
        return 0;
    }
}
