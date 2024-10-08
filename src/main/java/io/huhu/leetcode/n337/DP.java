package io.huhu.leetcode.n337;

class DP implements Code {

    @Override
    public int rob(TreeNode root) {
        int[] dp = f(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] f(TreeNode node) {
        int[] dp = new int[2];
        if (node == null) {
            return dp;
        }
        int[] l = f(node.left), r = f(node.right);
        dp[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        dp[1] = node.val + l[0] + r[0];
        return dp;
    }

}
