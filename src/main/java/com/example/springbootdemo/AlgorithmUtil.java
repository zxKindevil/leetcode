package com.example.springbootdemo;

public class AlgorithmUtil {
    public static void main(String[] args) {


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
}
