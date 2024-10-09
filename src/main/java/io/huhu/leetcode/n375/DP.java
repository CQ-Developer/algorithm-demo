package io.huhu.leetcode.n375;

class DP implements Code {

    @Override
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int l = n - 1; l >= 1; l--) {
            for (int r = l + 1; r <= n; r++) {
                int cost = Integer.MAX_VALUE;
                for (int i = l; i < r; i++) {
                    cost = Math.min(cost, Math.max(dp[l][i - 1], dp[i + 1][r]) + i);
                }
                dp[l][r] = cost;
            }
        }
        return dp[1][n];
    }

}
