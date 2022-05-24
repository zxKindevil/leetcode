package com.example.springbootdemo;

/**
 *
 */
public class Leet_0198_House_Robber {
    public static int[] test1 = new int[]{1, 2, 3, 1};
    public static int[] test2 = new int[]{2, 7, 9, 3, 1};
    public static int[] test3 = new int[]{0};
    public static int[] test4 = new int[]{2, 1, 1, 2};


    public static void main(String[] args) {
        System.out.println(new Leet_0198_House_Robber().rob(test1));
        System.out.println(new Leet_0198_House_Robber().rob(test2));
        System.out.println(new Leet_0198_House_Robber().rob(test3));
        System.out.println(new Leet_0198_House_Robber().rob(test4));
    }

    /**
     * i=0: v[0]
     * i=1: max(v[0],v[1])
     * i=2: max(v[i]+d[i-2],d[i-1])
     * d[i] = max(v[i]+d[i-2],d[i-1])
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] ans = new int[101];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }
        return dp(nums, nums.length - 1, ans);
    }

    public int dp(int[] nums, int i, int[] ans) {
        if (i == 0) {
            ans[0] = nums[0];
            return ans[0];
        }
        if (i == 1) {
            ans[1] = Math.max(nums[0], nums[1]);
            return ans[1];
        }
        if (ans[i] >= 0) {
            return ans[i];
        }
        ans[i] = Math.max(nums[i] + dp(nums, i - 2, ans), dp(nums, i - 1, ans));
        return ans[i];
    }
}
