package com.wd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test19 {
    public static void main(String[] args) {

    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 0;
        int i = citations.length - 1;
        while (i >= 0 && citations[i] >= (count + 1)) {
            count++;
            i--;
        }
        return count;
    }
}
