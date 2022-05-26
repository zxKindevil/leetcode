package com.example.springbootdemo;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class Leet_0221_max_square_DP {
    public static char[][] test1 = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
    public static char[][] test2 = new char[][]{{'1', '0'}, {'1', '0'}};
    public static char[][] test3 = new char[][]{{'0'}};

    public static void main(String[] args) {
        System.out.println(new Leet_0221_max_square_DP().maximalSquare(test1));
        System.out.println(new Leet_0221_max_square_DP().maximalSquare(test2));
        System.out.println(new Leet_0221_max_square_DP().maximalSquare(test3));
    }

    /**
     * 1 4 9 16
     * dp[i][j] = (sqrt(min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])) + 1)^2
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];

        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1' && i == 0) {
                    dp[i][j] = 1;
                }
                if (matrix[i][j] == '1' && j == 0) {
                    dp[i][j] = 1;
                }
                if (matrix[i][j] == '1' && j > 0 & i > 0) {
                    int min = Math.min(dp[i - 1][j],
                            Math.min(dp[i][j - 1], dp[i - 1][j - 1]));

                    dp[i][j] = (int) Math.pow(Math.sqrt(min) + 1, 2);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
