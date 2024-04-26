package com.wd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1146.快照数组
 */
public class Test05 {
    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0, 5);
        snapshotArray.snap();
        snapshotArray.set(0,6);
    }

}

/**
 * 想象成二维数组，但是二维数组我又不是叠加纵向坐标
 * 就搞了list中list
 * 每次生成快照都是对上一层级赋值一份数据
 */
class SnapshotArray {
    private List<List<Integer>> arrayList = new ArrayList<>();
    private int snap = 0;

    public SnapshotArray(int length) {
        List<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(0);
        }
        arrayList.add(list);
    }

    public void set(int index, int val) {
        arrayList.get(snap).set(index, val);
    }

    public int snap() {
        List<Integer> list = arrayList.get(arrayList.size() - 1);
        List<Integer> copyList = new ArrayList<>(list.size());
        copyList.addAll(list);
        arrayList.add(copyList);
        return snap++;
    }

    public int get(int index, int snap_id) {
        return arrayList.get(snap_id).get(index);
    }
}
