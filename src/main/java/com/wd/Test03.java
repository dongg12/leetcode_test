package com.wd;

/**
 * 2739.总行驶距离
 */
public class Test03 {
    public static void main(String[] args) {
        int mainTank = 10, additionalTank = 2;
        System.out.println(distanceTraveled(mainTank, additionalTank));
    }

    /**
     * 每次扣掉5L油，总耗费油增加5L
     * 循环条件就是主油箱少于5L，副油箱为0L退出循环
     *
     */
    public static int distanceTraveled(int mainTank, int additionalTank) {
        int sum = 0;
        while (mainTank >= 5 && additionalTank > 0) {
            mainTank = mainTank - 5;
            sum = sum + 5;
            mainTank = mainTank + 1;
            additionalTank = additionalTank - 1;
        }
        return (sum + mainTank) * 10;
    }
}

