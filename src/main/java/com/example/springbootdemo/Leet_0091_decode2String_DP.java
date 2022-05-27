package com.example.springbootdemo;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * https://leetcode.cn/problems/decode-ways/solution/jie-ma-fang-fa-tu-jie-dp-zui-qing-xi-yi-97hng/
 */
public class Leet_0091_decode2String_DP {

    public static void main(String[] args) {
//        System.out.println(new Leet_0091_decode2String_BFS().numDecodings("12"));
//        System.out.println(new Leet_0091_decode2String_BFS().numDecodings("226"));
//        System.out.println(new Leet_0091_decode2String_BFS().numDecodings("0"));
        System.out.println(new Leet_0091_decode2String_DP().numDecodings("2101"));
        System.out.println(new Leet_0091_decode2String_DP().numDecodings("111111111111111111111111111111111111111111111"));
        System.out.println(new Leet_0091_decode2String_DP().numDecodings("12"));
    }

    /**
     * 特别注意 char[i] == 0; dp[i] = dp[i-2]
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length];
        int[] dp = new int[chars.length];

        int n = -1;
        if (chars[0] == '0') {
            return 0;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0' &&
                    (chars[i - 1] == '0' || (chars[i - 1] != '1' && chars[i - 1] != '2'))) {
                return 0;
            }
            if (chars[i] == '0') {
                nums[n] = 26;
            } else {
                nums[++n] = Integer.valueOf(chars[i] + "");
            }
        }
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            Integer integer = Integer.valueOf(nums[i - 1] + "" + nums[i]);
            if (nums[i] != 26 && integer > 9 && integer <= 26) {
                if (i == 1) {
                    dp[1] = 2;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}

