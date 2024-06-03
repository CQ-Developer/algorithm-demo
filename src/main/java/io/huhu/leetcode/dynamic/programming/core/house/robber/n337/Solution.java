package io.huhu.leetcode.dynamic.programming.core.house.robber.n337;

/**
 * <a href="https://leetcode.cn/problems/house-robber-iii/description/">打家劫舍III</a>
 */
class Solution {

    public int rob(TreeNode root) {
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] dfs(TreeNode root) {
        // dp[0] 表示不偷当前房子能获取的最大收益
        // dp[1] 表示偷当前房子能获取的最大收益
        int[] dp = new int[2];
        // 空节点没有任何收益
        if (root == null) {
            return dp;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // 不偷当前节点的最大收益 = 左子树的最大收益 + 右子树的最大收益
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷当前节点的最大收益 = 不偷左子树的最大收益 + 不偷右子树的最大收益 + 偷当前节点收益
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }

}
