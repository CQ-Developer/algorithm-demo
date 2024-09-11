package io.huhu.leetcode.dynamic.programming.hard.n629;

class DP implements Solution {

    private static final int M = 1000000007;

    @Override
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int window = dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                if (i > j) {
                    window = (window + dp[i - 1][j]) % M;
                } else {
                    window = ((window + dp[i - 1][j]) % M - dp[i - 1][j - i] + M) % M;
                }
                dp[i][j] = window;
            }
        }
        return dp[n][k];
    }

}
