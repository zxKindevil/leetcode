package com.example.springbootdemo;

public class AlgorithmUtil {
    public static void main(String[] args) {


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


    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) { //这个条件很重要 只有一个元素不处理 两个元素要继续排序
            return;
        }
        int first = l, last = r, key = nums[first];
        while (first < last) {
            while (first < last && nums[last] >= key) {
                --last;
            }
            nums[first] = nums[last];
            while (first < last && nums[first] <= key) {
                ++first;
            }
            nums[last] = nums[first];
        }
        nums[first] = key;
        quickSort(nums, l, first);
        quickSort(nums, first + 1, r);
    }

    public static void printArray(int[][] arr) {
        for (int[] ints : arr) {
            printArray(ints);
        }
    }

    public static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + ",");
        }
        System.out.println();
    }

    public static void printArray(char[][] arr) {
        for (char[] items : arr) {
            printArray(items);
        }
    }

    public static void printArray(char[] arr) {
        for (char item : arr) {
            System.out.print(item + ",");
        }
        System.out.println();
    }
}
