package io.huhu.leetcode.dynamic.programming.hard.n903;

class DP implements Solution {

    private static final int M = 1000000007;

    @Override
    public int numPermsDISequence(String s) {
        char[] c = s.toCharArray();
        int n = c.length + 1;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[n][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || c[i - 1] == 'D') {
                    for (int k = 0; k < j; k++) {
                        dp[i][j] = (dp[i][j] + dp[i + 1][k]) % M;
                    }
                } else {
                    for (int k = j; k < n - i; k++) {
                        dp[i][j] = (dp[i][j] + dp[i + 1][k]) % M;
                    }
                }
            }
        }
        return dp[0][n];
    }

}
