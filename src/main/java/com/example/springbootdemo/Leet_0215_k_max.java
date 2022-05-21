package com.example.springbootdemo;


/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Leet_0215_k_max {
    public static int[] test1 = new int[]{3, 2, 1, 5, 6, 4};

    public static int[] test2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};

    public static int[] test3 = new int[]{5};

    public static int[] test4 = new int[]{4, 5};

    public static int[] test5 = new int[]{1, 2, 3};

    public static int[] test6 = new int[]{2, 1};

    public static void main(String[] args) {
        System.out.println(new Leet_0215_k_max().findKthLargest(test1, 2));
        System.out.println(new Leet_0215_k_max().findKthLargest(test2, 4));
        System.out.println(new Leet_0215_k_max().findKthLargest(test3, 1));
        System.out.println(new Leet_0215_k_max().findKthLargest(test4, 1));
        System.out.println(new Leet_0215_k_max().findKthLargest(test4, 2));
        System.out.println(new Leet_0215_k_max().findKthLargest(test5, 1));
        System.out.println(new Leet_0215_k_max().findKthLargest(test5, 2));
        System.out.println(new Leet_0215_k_max().findKthLargest(test5, 3));
        System.out.println(new Leet_0215_k_max().findKthLargest(test6, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    public int quickSort(int[] nums, int left, int right, int k) {
        if (left >= right) {//这个条件很重要 只有一个元素不处理 两个元素要继续排序
            if (nums.length - left == k) {
                return nums[left];
            } else {
                return -1;
            }
        }
        int l = left;
        int r = right;
        int key = nums[left];

        while (l < r) {
            while (l < r && nums[r] >= key) {
                r--;
            }
            nums[l] = nums[r];

            while (l < r && nums[l] <= key) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = key;
        if (nums.length - l == k) {
            return key;
        }
        int ret = quickSort(nums, left, l, k);
        if (ret >= 0) {
            return ret;
        }
        return quickSort(nums, l + 1, right, k);
    }
}

