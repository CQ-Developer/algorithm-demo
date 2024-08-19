package io.huhu.leetcode.binary.tree.easy.n222;

/**
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/description/">
 * Count Complete Tree Nodes
 * </a>
 */
class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return f(root, 1, mostLeft(root, 1));
    }

    private int mostLeft(TreeNode cur, int level) {
        while (cur != null) {
            level++;
            cur = cur.left;
        }
        return level - 1;
    }

    private int f(TreeNode cur, int level, int height) {
        if (level == height) {
            return 1;
        }
        // 左数是一颗满二叉数
        if (mostLeft(cur.right, level + 1) == height) {
            return (1 << (height - level)) + f(cur.right, level + 1, height);
        }
        // 右树是一颗满二叉树
        return (1 << (height - level - 1)) + f(cur.left, level + 1, height);
    }

}
