package com.wd;

import java.util.*;

/**
 * O（1）时间插入删除获取随机元素
 */
public class Test20 {
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(1));
        System.out.println(set.remove(2));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
        System.out.println(set.remove(1));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());

    }
}

class RandomizedSet {
    private HashSet<Integer> set;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean flag;
        if (flag = set.add(val)){
            list.add(val);
        }
        return flag;
    }

    public boolean remove(int val) {
        boolean flag;
        if (flag = set.remove(val)){
            list.remove(new Integer(val));
        }
        return flag;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
