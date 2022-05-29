package com.example.springbootdemo;


/**
 * 474. 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * 多重背包 https://leetcode.cn/circle/article/2ZcRi7/
 * 背包九讲：https://leetcode.cn/problems/coin-change/solution/by-flix-su7s/
 */
public class Leet_0474_one_zere_max_sub_01P {
    public static String[] test1 = new String[]{"10", "0001", "111001", "1", "0"};
    public static String[] test2 = new String[]{"10", "0", "1"};
    public static int test1_m = 5;
    public static int test2_m = 1;
    public static int test1_n = 3;
    public static int test2_n = 1;

    public static void main(String[] args) {
//        System.out.println(new Leet_0474_one_zere_max_sub_01P().findMaxForm(test1, test1_m, test1_n));
        System.out.println(new Leet_0474_one_zere_max_sub_01P().findMaxForm(test2, test2_m, test2_n));
    }

    /**
     * 三维 01 背包
     * m=count(0)
     * n=count(1)
     * int c0 = str.count0;
     * int c1 = str.count1;
     * value = 1;
     * if(m-c0>=0 && n-c1>=0)
     * dp[i][m][n]= max(dp[i - 1][j][k], dp[i - 1][j - count0][k - count1] + value)
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];

        for (int i = 1; i <= length; i++) {
            String str = strs[i - 1];
            int count0 = count(str, '0');
            int count1 = count(str, '1');
            int value = 1;
            for (int j = 0; j <= m; j++) {//这里可以0
                for (int k = 0; k <= n; k++) {//这里可以0
                    if (j - count0 >= 0 && k - count1 >= 0) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k]
                                , dp[i - 1][j - count0][k - count1] + value);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
//                System.out.println("i="+i+"");
//                AlgorithmUtil.printArray(dp[i]);
            }
        }
        return dp[length][m][n];
    }

    private int count(String str, char target) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            if (ch == target) {
                sum++;
            }
        }
        return sum;
    }
}
