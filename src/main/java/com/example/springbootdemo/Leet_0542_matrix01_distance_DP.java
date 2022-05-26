package com.example.springbootdemo;

/**
 * todo
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 */
public class Leet_0542_matrix01_distance_DP {
    public static int[][] test1 = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

    public static void main(String[] args) {
        AlgorithmUtil.printArray(new Leet_0542_matrix01_distance_BFS().updateMatrix(test1));
    }

    /**
     * dp[i][j] = min(dp[i-1][j],dp[i+1][j],dp[i][j-1],dp[i][j+1])+1;
     *
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int[][] ans = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                ans[i][j] = -1;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                ans[i][j] = dp(i, j, mat, ans);
            }
        }


        return ans;

    }

    private int dp(int left, int right, int[][] mat, int[][] ans) {


        if (left < 0 || left > mat.length || right < 0 || right > mat[0].length) {
            return 999999;
        }
        if (mat[left][right] == 0) {
            return ans[left][right] = 0;
        }
        if (ans[left][right] >= 0) {
            return ans[left][right];
        }
        return ans[left][right] = 1 +
                Math.min(dp(left - 1, right, mat, ans),
                        Math.min(dp(left + 1, right, mat, ans),
                                Math.min(dp(left, right - 1, mat, ans), dp(left, right + 1, mat, ans))));
    }

}