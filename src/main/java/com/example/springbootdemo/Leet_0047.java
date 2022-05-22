package com.example.springbootdemo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class Leet_0047 {
    public static int[] test1 = new int[]{1, 1, 2};
    public static int[] test2 = new int[]{1, 2, 3};
    public static int[] test3 = new int[]{1, 2, 3, 3};

    public static void main(String[] args) {
        List<List<Integer>> ret1 = new Leet_0047().permuteUnique(test1);
        System.out.println(ret1);


        List<List<Integer>> ret2 = new Leet_0047().permuteUnique(test2);
        System.out.println(ret2);

        List<List<Integer>> ret3 = new Leet_0047().permuteUnique(test3);
        System.out.println(ret3);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);//排序是剪枝的基础
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
            //已经访问过得，剪枝
            //两个相同的数字,减去第二个数字被先使用的场景,因为会重复
            //https://leetcode.cn/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
            if (visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])) {
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

