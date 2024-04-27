package com.wd;

/**
 * 2639.查询网格图中每一列的宽度
 */
public class Test07 {
    public static void main(String[] args) {

    }


    public int[] findColumnWidth(int[][] grid) {
        int[] arr = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max,String.valueOf(grid[j][i]).length());
            }
            arr[i] = max;
        }
        return arr;
    }
}
