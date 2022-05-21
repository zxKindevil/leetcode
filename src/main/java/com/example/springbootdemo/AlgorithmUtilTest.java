package com.example.springbootdemo;

public class AlgorithmUtilTest {
    public static void main(String[] args) {
        testQuickSort();

    }

    public static void testQuickSort() {
        int[] testArr1 = new int[]{3, 2, 7, 4, 5, 9, 2, 5, 7, 8, 9, 2, 1, 3};
        AlgorithmUtil.quickSort(testArr1, 0, testArr1.length - 1);
        AlgorithmUtil.printArray(testArr1);

        int[] testArr2 = new int[]{3};
        AlgorithmUtil.quickSort(testArr2, 0, testArr2.length - 1);
        AlgorithmUtil.printArray(testArr2);

        int[] testArr3 = new int[]{3, 7, 4, 6, 9, 2, 5, 8, 1};
        AlgorithmUtil.quickSort(testArr3, 0, testArr3.length - 1);
        AlgorithmUtil.printArray(testArr3);

        int[] testArr4 = new int[]{2, 1};
        AlgorithmUtil.quickSort(testArr4, 0, testArr4.length - 1);
        AlgorithmUtil.printArray(testArr4);
    }
}
