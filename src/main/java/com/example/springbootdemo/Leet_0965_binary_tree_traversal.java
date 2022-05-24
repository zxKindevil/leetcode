package com.example.springbootdemo;


/**
 * 二叉树遍历
 */
public class Leet_0965_binary_tree_traversal {

    public static void main(String[] args) {
        //[1,2,3,null,5]
        TreeNode test1 = new TreeNode(1,
                new TreeNode(1,
                        null,
                        new TreeNode(1)),
                new TreeNode(1));
        System.out.println(new Leet_0965_binary_tree_traversal().isUnivalTree(test1));
    }

    /**
     * dfs 遍历二叉树
     *
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null) {
            if (root.val == root.left.val) {
                boolean result = dfs(root.left);
                if (!result) {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (root.right != null) {
            if (root.val == root.right.val) {
                boolean result = dfs(root.right);
                if (!result) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}



