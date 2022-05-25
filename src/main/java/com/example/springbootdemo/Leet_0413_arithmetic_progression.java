package com.example.springbootdemo;


/**
 * 413. 等差数列划分
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <p>
 * 子数组 是数组中的一个连续序列。
 * https://leetcode.cn/problems/arithmetic-slices/solution/deng-chai-shu-lie-hua-fen-by-leetcode-so-g7os/
 */
public class Leet_0413_arithmetic_progression {
    public static int[] test1 = new int[]{1, 2, 3, 4};
    public static int[] test2 = new int[]{1, 3, 5, 7, 9};
    public static int[] test3 = new int[]{1, 2, 3, 8, 9, 10};


    public static void main(String[] args) {
        System.out.println(new Leet_0413_arithmetic_progression().numberOfArithmeticSlices(test1));
        System.out.println(new Leet_0413_arithmetic_progression().numberOfArithmeticSlices(test2));
        System.out.println(new Leet_0413_arithmetic_progression().numberOfArithmeticSlices(test3));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;

        int count = 0;
        for (int i = 2; i < nums.length; i++) {

            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                ans += ++count;
            } else {
                count = 0;
            }

        }
        return ans;
    }

//    //solution1
//    public int numberOfArithmeticSlices(int[] nums) {
//        int[] ans = new int[nums.length];
//
//        for (int i = 2; i < nums.length; i++) {
//
//            ans[i] = ans[i - 1] + arithmetic(nums, i);
//        }
//        return ans[nums.length - 1];
//    }
//    private int arithmetic(int[] nums, int i) {
//        int count = 0;
//        for (int j = i; j - 2 >= 0; j--) {
//            if (nums[j] - nums[j - 1] == nums[j - 1] - nums[j - 2]) {
//                count++;
//            } else {
//                break;
//            }
//        }
//        return count;
//    }
}
