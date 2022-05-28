package com.example.springbootdemo;


import com.google.common.collect.Lists;

import java.util.List;

/**
 * todo
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class Leet_0139_word_break_DP {
    public static String test1_s = "leetcode";
    public static String[] test1_dict = new String[]{"leet", "code"};
    public static String test2_s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    public static String[] test2_dict = new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};

    public static void main(String[] args) {
        System.out.println(new Leet_0139_word_break_DP().wordBreak(test1_s, Lists.newArrayList(test1_dict)));
        System.out.println(new Leet_0139_word_break_DP().wordBreak(test2_s, Lists.newArrayList(test2_dict)));

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] visit = new int[s.length()];
        for (int i = 0; i < visit.length; i++) {
            visit[i] = -1;
        }
        return dfs(0, s, wordDict, visit);
    }

    public boolean dfs(int start, String str, List<String> wordDict, int[] visit) {
        if (start == str.length()) {
            return true;
        }
        if (visit[start] != -1) {
            return visit[start] == 1;
        }

        for (int i = start; i < str.length(); i++) {
            String word = str.substring(start, i + 1);
            if (wordDict.contains(word) && dfs(i + 1, str, wordDict, visit)) {
                visit[start] = 1;
                return true;
            }
        }
        visit[start] = 0;
        return false;
    }
}

