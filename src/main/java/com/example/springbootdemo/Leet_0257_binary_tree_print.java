package com.example.springbootdemo;


import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class Leet_0257_binary_tree_print {

    public static void main(String[] args) {
        //[1,2,3,null,5]
        TreeNode test1 = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(5)),
                new TreeNode(3));
        List<String> ret1 = new Leet_0257_binary_tree_print().binaryTreePaths(test1);
        System.out.println(ret1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(root.val + "");
        }
        if (root.left != null) {
            dfs(root.left, root.val + "", result);
        }
        if (root.right != null) {
            dfs(root.right, root.val + "", result);
        }
        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path + "->" + root.val);
        }
        if (root.left != null) {
            dfs(root.left, path + "->" + root.val, result);
        }
        if (root.right != null) {
            dfs(root.right, path + "->" + root.val, result);
        }
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



