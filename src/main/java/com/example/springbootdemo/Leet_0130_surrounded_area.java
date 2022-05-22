package com.example.springbootdemo;


import java.util.Stack;



/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */

public class Leet_0130_surrounded_area {
    public static char[][] test1 = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};

    public static void main(String[] args) {
        new Leet_0130_surrounded_area().solve(test1);
        AlgorithmUtil.printArray(test1);
    }

    public static void upRightDownLeft(int i, int j, char[][] array, Func func) {
        //up(-1,0),right(0,1),down(1,0),left(0,-1)
        int[] direction = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            if ((i + direction[k] >= 0)
                    && (i + direction[k] < array.length)
                    && (j + direction[k + 1] >= 0)
                    && (j + direction[k + 1] < array[0].length))
                func.consume(i + direction[k], j + direction[k + 1], array[i + direction[k]][j + direction[k + 1]]);
        }
    }

    /**
     * 先把靠边的dfs置为'A'
     * 然后把没有标记为 A的置为X, A置为'O'
     *
     * @param board
     */
    public void solve(char[][] board) {
        //up
        for (int j = 0; j < board[0].length; j++) {
            dfs(board, 0, j);
        }
        //down
        for (int j = 0; j < board[0].length; j++) {
            dfs(board, board.length - 1, j);
        }
        //left
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
        }
        //right
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'X') {
            return;
        }

        Stack<Node> stack = new Stack<>();
        board[i][j] = 'A';
        stack.push(new Node(i, j));
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            upRightDownLeft(pop.i, pop.j, board, new Func() {
                @Override
                public void consume(int i, int j, char value) {
                    if (value == 'O') {
                        board[i][j] = 'A';
                        stack.push(new Node(i, j));
                    }
                }
            });
        }

    }


}

interface Func {
    void consume(int i, int j, char value);
}

class Node {
    public int i;
    public int j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}


