package com.wd;

import java.util.PriorityQueue;

/**
 * 1329.将矩阵按对角线排序
 */
public class Test15 {
    public static void main(String[] args) {
    }

    /**
     * 这个遍历规律有点麻烦
     * 就是对角线遍历大小，然后排序赋值
     * 返回
     */
    public int[][] diagonalSort(int[][] mat) {

        int zong = mat.length;
        int heng = mat[0].length;
        for (int i = 0; i < heng; i++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int j = 0; j < zong && i+j <heng; j++) {
                queue.offer(mat[j][i + j]);
            }

            for (int j = 0; j < zong && i+j <heng; j++) {
                mat[j][i + j] = queue.poll();
            }
        }

        for (int i = 1; i < zong; i++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int j = 0; j < heng && i+j < zong; j++) {
                queue.offer(mat[i+j][j]);
            }

            for (int j = 0; j < heng && i+j < zong; j++) {
                mat[i+j][j] = queue.poll();
            }
        }
        return mat;
    }
}
