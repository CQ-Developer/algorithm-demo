package io.huhu.leetcode.binary.tree.easy.n543;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/description/">
 * Diameter of Binary Tree
 * </a>
 */
class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        return f(root).diameter;
    }

    private Info f(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info left = f(root.left), right = f(root.right);
        int height = Math.max(left.height, right.height) + 1;
        int diameter = Math.max(left.height + right.height, Math.max(left.diameter, right.diameter));
        return new Info(diameter, height);
    }

    static class Info {

        final int diameter;
        final int height;

        Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }

    }

}
