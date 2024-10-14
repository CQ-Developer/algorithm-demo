package io.huhu.leetcode.n518;

import java.util.Arrays;

class DP implements Code {

    @Override
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                for (int k = i; k < n && coins[k] <= j; k++) {
                    dp[i][j] += dp[k][j - coins[k]];
                }
            }
        }
        return dp[0][amount];
    }

}
