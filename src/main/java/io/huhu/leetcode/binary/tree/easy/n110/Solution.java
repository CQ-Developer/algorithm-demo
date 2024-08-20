package io.huhu.leetcode.binary.tree.easy.n110;

/**
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/description/">
 * Balanced Binary Tree
 * </a>
 */
class Solution {

    boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return balance;
    }

    private int height(TreeNode root) {
        if (!balance || root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        if (Math.abs(l - r) > 1) {
            balance = false;
        }
        return Math.max(l, r) + 1;
    }

}
