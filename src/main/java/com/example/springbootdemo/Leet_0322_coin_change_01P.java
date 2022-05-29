package com.example.springbootdemo;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * https://leetcode.cn/problems/coin-change/solution/by-flix-su7s/
 */
public class Leet_0322_coin_change_01P {
    public static int[][] test = new int[][]{
            {5, 2, 1}
            , {2}
            , {1}
    };
    public static int[] test_amount = new int[]{
            11,
            3,
            0
    };

    public static void main(String[] args) {
        for (int i = 0; i < test.length; i++) {
            System.out.println(new Leet_0322_coin_change_01P().coinChange(test[i], test_amount[i]));
        }
    }

    /**
     * 完全背包问题
     * 如果要求恰好装满背包，那么在初始化时 dp[i][0]=0 dp[i][0]=0，其它 dp[i][1,2,...,*]dp[i][1,2,...,∗] 均设为 -∞−∞。这是因为此时只有容量为 00 的背包可能被价值为 00 的 nothing “恰好装满”，而其它容量的背包均没有合法的解，属于未定义的状态。
     * <p>
     * dp[i][j] = Math.max(dp[i-1][j],dp[i][j-w]+v);
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int length = coins.length;
        int[][] dp = new int[length + 1][amount + 1];

        for (int i = 0; i < length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j != 0) {//如果要求恰好装满背包，那么在初始化时 dp[i][0]=0dp[i][0]=0，其它 dp[i][1,2,...,*]dp[i][1,2,...,∗] 均设为 -∞−∞。这是因为此时只有容量为 00 的背包可能被价值为 00 的 nothing “恰好装满”，而其它容量的背包均没有合法的解，属于未定义的状态。
                    dp[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        for (int i = 1; i < length + 1; i++) {
            int weight = coins[i - 1];
            int value = 1;
            for (int j = 0; j < amount + 1; j++) {
                if (j - weight >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - weight] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

//            System.out.println("i=" + i);
//            AlgorithmUtil.printArray(dp);

        }
        if (dp[length][amount] >= Integer.MAX_VALUE / 2) {
            return -1;
        }
        return dp[length][amount];
    }
}