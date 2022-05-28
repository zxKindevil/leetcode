package com.example.springbootdemo;


/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class Leet_0416_partition_equal_sub_01P {
    public static int[] test1 = new int[]{1, 5, 11, 5};
    public static int[] test2 = new int[]{1, 2, 3, 5};

    public static void main(String[] args) {
        System.out.println(new Leet_0416_partition_equal_sub_01P().canPartition(test1));
        System.out.println(new Leet_0416_partition_equal_sub_01P().canPartition(test2));
    }

    /**
     * 01背包问题，能否选出几个数，刚好等于 1 半
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 > 0) {
            return false;
        }
        int weight = sum / 2;
        int[][] dp = new int[nums.length + 1][weight + 1];

        for (int i = 1; i <= nums.length; i++) {
            int w = nums[i-1];
            int value = nums[i-1];
            for (int j = 1; j <= weight; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
//            System.out.println("===");
//            AlgorithmUtil.printArray(dp);
            if (dp[i][weight] == weight) {
                return true;
            }
        }

        return false;
    }
}