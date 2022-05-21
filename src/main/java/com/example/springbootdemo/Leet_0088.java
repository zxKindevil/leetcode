package com.example.springbootdemo;


/**
 * 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class Leet_0088 {
    public static int[] test1_n1 = new int[]{1,2,3,0,0,0};
    public static int[] test1_n2 = new int[]{2,5,6};

    public static int[] test2_n1 = new int[]{0};
    public static int[] test2_n2 = new int[]{1};

    public static void printArray(int[][] arr) {
        for (int[] ints : arr) {
            printArray(ints);
        }
    }

    public static void printArray(int[] arr){
        for (int item : arr) {
            System.out.print(item+ ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Leet_0088().merge(test1_n1,3,test1_n2,test1_n2.length);
        printArray(test1_n1);

        new Leet_0088().merge(test2_n1,0,test2_n2,test2_n2.length);
        printArray(test2_n1);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int arr1Tail = m - 1;
        int arr2Tail = n - 1;
        int retTail = m + n - 1;

        while (arr1Tail >= 0 || arr2Tail >= 0) {
            if(arr1Tail < 0) {
                nums1[retTail--] = nums2[arr2Tail--];
            }
            else if(arr2Tail < 0) {
                nums1[retTail--] = nums1[arr1Tail--];
            }
            else if (nums1[arr1Tail] > nums2[arr2Tail]) {
                nums1[retTail--] = nums1[arr1Tail--];
            } else {
                nums1[retTail--] = nums2[arr2Tail--];
            }
        }

    }
}

