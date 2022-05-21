package com.example.springbootdemo;

public class Leet_0167 {
    public static int[] test1 = new int[]{2, 7, 11, 15};
    public static int test1_target = 9;

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

    public static void main(String[] args) {
        printArray(new Leet_0167().twoSum(test1, test1_target));
    }

    public int[] twoSum(int[] numbers, int target) {
        return twoSum(numbers, 0, numbers.length - 1, target);
    }

    public int[] twoSum(int[] numbers, int left, int right, int target) {
        if (numbers[left] + numbers[right] == target) {
            return new int[]{left + 1, right + 1};
        } else if (numbers[left] + numbers[right] < target) {
            return twoSum(numbers, left + 1, right, target);
        } else {
            return twoSum(numbers, left, right - 1, target);
        }
    }

}
