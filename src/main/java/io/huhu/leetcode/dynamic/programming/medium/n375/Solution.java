package io.huhu.leetcode.dynamic.programming.medium.n375;

/**
 * <a href="https://leetcode.cn/problems/guess-number-higher-or-lower-ii/description/">Guess Number Higher or Lower II</a>
 */
class Solution {

    /**
     * 1 <= n <= 200
     */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = j + dp[i][j - 1];
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }

}
