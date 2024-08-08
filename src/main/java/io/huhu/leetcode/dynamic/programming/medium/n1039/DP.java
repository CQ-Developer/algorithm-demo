package io.huhu.leetcode.dynamic.programming.medium.n1039;

class DP implements Solution {

    @Override
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                dp[l][r] = Integer.MAX_VALUE;
                for (int m = l + 1; m < r; m++) {
                    dp[l][r] = Integer.min(dp[l][r], dp[l][m] + dp[m][r] + values[l] * values[m] * values[r]);
                }
            }
        }
        return dp[0][n - 1];
    }

}
