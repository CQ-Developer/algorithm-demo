package io.huhu.leetcode.dynamic.programming.medium.n96;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees/description/">不同的二叉搜索树</a>
 */
class Solution {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= len; i++) {
                dp[len] += dp[i - 1] * dp[len - i];
            }
        }
        return dp[n];
    }

}
