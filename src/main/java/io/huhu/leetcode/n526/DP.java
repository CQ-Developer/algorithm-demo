package io.huhu.leetcode.n526;

import java.util.Arrays;

class DP implements Code {

    @Override
    public int countArrangement(int n) {
        int m = 1 << (n + 1);
        int[][] dp = new int[n + 1][m];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                for (int num = 1; num <= n; num++) {
                    if (((1 << num) & j) == 0 && (i % num == 0 || num % i == 0)) {
                        dp[i][j] += dp[i - 1][(1 << num) | j];
                    }
                }
            }
        }
        return dp[n][0];
    }

}
