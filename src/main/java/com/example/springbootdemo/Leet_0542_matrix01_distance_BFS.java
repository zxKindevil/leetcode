package com.example.springbootdemo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * https://leetcode.cn/problems/01-matrix/solution/01ju-zhen-by-leetcode-solution/
 */
public class Leet_0542_matrix01_distance_BFS {
    public static int[][] test1 = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

    public static void main(String[] args) {
        AlgorithmUtil.printArray(new Leet_0542_matrix01_distance_BFS().updateMatrix(test1));
    }

    public static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {

        int row = mat.length;
        int column = mat[0].length;
        int[][] ans = new int[row][column];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) { //把所有 0 看成一个整体 一个大0 每 BFS 一圈 距离+1
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] head = queue.poll();

            int left = head[0];
            int right = head[1];

            for (int d = 0; d < 4; d++) {
                int nextLeft = left + direction[d][0];
                int nextRight = right + direction[d][1];

                if (nextLeft >= 0 && nextLeft < row && nextRight >= 0 && nextRight < column) {
                    if (ans[nextLeft][nextRight] >= 0) {
                        continue;
                    }
                    queue.add(new int[]{nextLeft, nextRight});
                    ans[nextLeft][nextRight] = ans[left][right] + 1;
                }


            }

        }

        return ans;

    }

}
