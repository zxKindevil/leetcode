package com.example.springbootdemo;


import java.util.List;

/**
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class Leet_0226_binary_tree_invert {

    public static void main(String[] args) {
        //[1,2,3,null,5]
        TreeNode test1 = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(5)),
                new TreeNode(3));
        TreeNode treeNode = new Leet_0226_binary_tree_invert().invertTree(test1);
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode newRight = null;
        TreeNode newLeft = null;

        if(root.left != null) {
            newRight = invertTree(root.left);
        }
        if(root.right != null) {
            newLeft = invertTree(root.right);
        }
        root.left = newLeft;
        root.right = newRight;

        return root;
    }


}






