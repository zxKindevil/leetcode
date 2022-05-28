package com.example.springbootdemo;


/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * https://leetcode.cn/problems/longest-common-subsequence/solution/zui-chang-gong-gong-zi-xu-lie-by-leetcod-y7u0/
 * <p>
 */
public class Leet_1143_longest_com_sub_DP {
    public static String test1_ch1 = "abcde";
    public static String test1_ch2 = "ace";

    public static void main(String[] args) {
        System.out.println(new Leet_1143_longest_com_sub_DP()
                .longestCommonSubsequence(test1_ch1, test1_ch2));

    }

    /**
     * dp[0][j] = 0;
     * dp[i][0] = 0;
     * dp[i][j] = dp[i-1][j-1]+1; text1[i]==text2[j]
     * dp[i][j] = max(dp[i-1][j],dp[i][j-1]) ;text1[i]!=text2[j]
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int column = text2.length();
        int[][] dp = new int[row + 1][column + 1];

        for (int i = 1; i <= row; i++) {
            char ch1 = text1.charAt(i - 1);
            for (int j = 1; j <= column; j++) {
                char ch2 = text2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[row][column];

    }
}