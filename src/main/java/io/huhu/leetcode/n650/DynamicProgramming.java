package io.huhu.leetcode.n650;

class DynamicProgramming implements Code {

    @Override
    public int minSteps(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 1001;
            }
        }
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = 1001;
            for (int j = 0; j <= i / 2; j++) {
                dp[i][j] = dp[i - j][j] + 1;
                min = Math.min(min, dp[i][j]);
            }
            dp[i][i] = min + 1;
        }
        int ans = 1001;
        for (int j = 0; j <= n; j++) {
            ans = Math.min(ans, dp[n][j]);
        }
        return ans;
    }

}
