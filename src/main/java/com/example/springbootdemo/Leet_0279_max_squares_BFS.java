package com.example.springbootdemo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * https://leetcode.cn/problems/perfect-squares/solution/python3zui-ji-chu-de-bfstao-lu-dai-ma-gua-he-ru-me/
 */
public class Leet_0279_max_squares_BFS {

    public static void main(String[] args) {
        System.out.println(new Leet_0279_max_squares_BFS().numSquares(12));
        System.out.println(new Leet_0279_max_squares_BFS().numSquares(13));
        System.out.println(new Leet_0279_max_squares_BFS().numSquares(2));
    }

    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        queue.add(n);
        visit[n] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer temp = queue.poll();
                for (int j = 1; j * j <= temp; j++) {
                    int rest = temp - j * j;//位置 i 只依赖 i - k2 的位置，如 i - 1、i - 4、i - 9 等等
                    if (rest == 0) {
                        return level;
                    }
                    if (!visit[rest]) {
                        queue.add(rest);
                        visit[rest] = true;
                    }
                }
            }
        }
        return -1;
    }
}
