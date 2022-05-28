package com.example.springbootdemo;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class Leet_0300_max_ascend_sub_num_DFS {
    public static int[] test1 = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
    public static int[] test2 = new int[]{0, 1, 0, 3, 2, 3};
    public static int[] test3 = new int[]{7, 7, 7, 7, 7, 7, 7};
    public static int[] test4 = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};//


    public static void main(String[] args) {
        System.out.println(new Leet_0300_max_ascend_sub_num_DFS().lengthOfLIS(test1));
        System.out.println(new Leet_0300_max_ascend_sub_num_DFS().lengthOfLIS(test2));
        System.out.println(new Leet_0300_max_ascend_sub_num_DFS().lengthOfLIS(test3));
        System.out.println(new Leet_0300_max_ascend_sub_num_DFS().lengthOfLIS(test4));
    }

    public int lengthOfLIS(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }

        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int dfs = dfs(i, 0, nums, ans);
            ans[i] = dfs + 1;
            max = Math.max(max, ans[i]);
        }

        return max;
    }

    private int dfs(int step, int count, int[] nums, int[] ans) {
        if (step == nums.length - 1) {
            return count;
        }
        if (ans[step] != -1) {
            return ans[step];
        }

        int subMax = 0;
        for (int i = step + 1; i < nums.length; i++) {
            if (nums[i] > nums[step]) {
                int subResult = dfs(i, count + 1, nums, ans);
                subMax = Math.max(subMax, subResult);
            }
        }
        return subMax;
    }
}