package io.huhu.leetcode.dynamic.programming.hard.n629;

class DP implements Solution {

    private static final int M = 1000000007;

    @Override
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                if (i > j) {
                    for (int p = 0; p <= j; p++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][p]) % M;
                    }
                } else {
                    for (int p = j - i + 1; p <= j; p++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][p]) % M;
                    }
                }
            }
        }
        return dp[n][k];
    }

}
