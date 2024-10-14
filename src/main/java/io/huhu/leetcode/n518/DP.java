package io.huhu.leetcode.n518;

class DP implements Code {

    @Override
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[n][0] = 1;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i]) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i][j - coins[i]] + dp[i + 1][j];
                }
            }
        }
        return dp[0][amount];
    }

}
