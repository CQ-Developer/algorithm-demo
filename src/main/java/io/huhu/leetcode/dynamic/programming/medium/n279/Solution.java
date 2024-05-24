package io.huhu.leetcode.dynamic.programming.medium.n279;

/**
 * <a href="https://leetcode.cn/problems/perfect-squares/description/">完全平方数</a>
 */
class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // dp[i]表示完全平方数和为i的最小个数
            // 最大可能就是i，即1+1+...+1
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                // dp[i-j*j]表示上一个完全平方和小于i的最小个数
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

}
