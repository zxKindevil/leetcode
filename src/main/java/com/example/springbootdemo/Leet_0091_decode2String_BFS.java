package com.example.springbootdemo;

import java.util.Stack;

/**
 * 超时 todo 可以优化
 *
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
 */
public class Leet_0091_decode2String_BFS {

    public static void main(String[] args) {
//        System.out.println(new Leet_0091_decode2String_BFS().numDecodings("12"));
//        System.out.println(new Leet_0091_decode2String_BFS().numDecodings("226"));
//        System.out.println(new Leet_0091_decode2String_BFS().numDecodings("0"));
        System.out.println(new Leet_0091_decode2String_BFS().numDecodings("2101"));
        System.out.println(new Leet_0091_decode2String_BFS().numDecodings("111111111111111111111111111111111111111111111"));
    }

    public int numDecodings(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            if (cur == chars.length - 1) {
                ans++;
                System.out.println(ans);
            }
            if (cur + 1 < chars.length) {
                Integer integer = Integer.valueOf(chars[cur + 1] + "");
                if (integer > 0) {
                    stack.push(cur + 1);
                }
            }
            if (cur + 2 < chars.length) {
                Integer integer = Integer.valueOf(chars[cur + 1] + "" + chars[cur + 2]);
                if (integer > 9 && integer <= 26) {
                    stack.push(cur + 2);
                }
            }
        }
        return ans;
    }
}

