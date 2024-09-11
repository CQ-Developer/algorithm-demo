package io.huhu.leetcode.dynamic.programming.hard.n629;

class DP implements Solution {

    private static final int M = (int) 1E9 + 7;

    @Override
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            long window = 1;
            for (int j = 1; j <= k; j++) {
                window += dp[i - 1][j];
                if (j >= i) {
                    window -= dp[i - 1][j - i];
                }
                dp[i][j] = (int) (window % M);
            }
        }
        return dp[n][k];
    }

}
