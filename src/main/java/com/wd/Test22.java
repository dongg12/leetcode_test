package com.wd;

/**
 * 134.加油站
 */
public class Test22 {
    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int num = 0;
        int count = 0;
        int startIndex = 0;
        int temp = 0;
        for (; count < gas.length; startIndex++) {
            if (startIndex == gas.length){
                startIndex = 0;
            }
            num = num + gas[startIndex] - cost[startIndex];
            count++;
            if (num < 0){
                num = 0;
                count = 0;
                if (++temp == gas.length){
                    return -1;
                }
                startIndex = temp - 1;
            }

        }
        return temp;
    }

    public int canCompleteCircuitV2(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < gas.length; i++){
            sum = sum + gas[i] - cost[i];
            if(sum < min && sum < 0){
                min = sum;
                minIndex = i;
            }
        }
        if(sum < 0) return -1;
        return minIndex + 1;
    }
}
