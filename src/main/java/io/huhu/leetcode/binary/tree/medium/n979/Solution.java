package io.huhu.leetcode.binary.tree.medium.n979;

/**
 * <a href="https://leetcode.cn/problems/distribute-coins-in-binary-tree/description/">
 * Distribute Coins in Binary Tree
 * </a>
 */
class Solution {

    public int distributeCoins(TreeNode root) {
        return f(root).steps;
    }

    private Info f(TreeNode root) {
        if (root == null) {
            return new Info(0, 0, 0);
        }
        Info left = f(root.left), right = f(root.right);
        int nodes = left.nodes + right.nodes + 1;
        int coins = left.coins + right.coins + root.val;
        int steps = left.steps + right.steps + Math.abs(left.coins - left.nodes) + Math.abs(right.coins - right.nodes);
        return new Info(nodes, coins, steps);
    }

    static class Info {

        final int nodes;
        final int coins;
        final int steps;

        Info(int nodes, int coins, int steps) {
            this.nodes = nodes;
            this.coins = coins;
            this.steps = steps;
        }

    }

}
