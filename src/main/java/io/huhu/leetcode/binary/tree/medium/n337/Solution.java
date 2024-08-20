package io.huhu.leetcode.binary.tree.medium.n337;

/**
 * <a href="https://leetcode.cn/problems/house-robber-iii/description/">
 * House Robber III
 * </a>
 */
class Solution {

    public int rob(TreeNode root) {
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }

    /**
     * dp[0]: don't rob cur node
     * dp[1]: rob cur node
     */
    private int[] dfs(TreeNode cur) {
        int[] dp = new int[2];
        if (cur == null) {
            return dp;
        }
        int[] left = dfs(cur.left);
        int[] right = dfs(cur.right);
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = cur.val + left[0] + right[0];
        return dp;
    }

}
