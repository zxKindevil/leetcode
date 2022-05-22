package com.example.springbootdemo;


import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Leet_0046_permute {
    public static int[] test1 = new int[]{1, 2, 3};
    public static int[] test2 = new int[]{1, 0};
    public static int[] test3 = new int[]{1};

    public static void main(String[] args) {
        List<List<Integer>> ret1 = new Leet_0046_permute().permute(test1);
        System.out.println(ret1);


        List<List<Integer>> ret2 = new Leet_0046_permute().permute(test2);
        System.out.println(ret2);

        List<List<Integer>> ret3 = new Leet_0046_permute().permute(test3);
        System.out.println(ret3);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        int[] temp = new int[nums.length];
        dfs(nums, visit, 0, temp, result);
        return result;
    }

    private void dfs(int[] nums, boolean[] visit, int level, int[] temp, List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(builList(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            temp[level] = nums[i];
            visit[i] = true;
            dfs(nums, visit, level + 1, temp, result);
            temp[level] = -1;
            visit[i] = false;
        }
    }

    private List<Integer> builList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }


}

