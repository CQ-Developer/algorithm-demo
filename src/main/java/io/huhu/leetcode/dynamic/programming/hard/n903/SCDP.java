package io.huhu.leetcode.dynamic.programming.hard.n903;

/**
 * States Compression DP
 */
class SCDP implements Solution {

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
            if (i == 0 || c[i - 1] == 'D') {
                dp[i][1] = dp[i + 1][0];
                for (int j = 2; j <= n; j++) {
                    dp[i][j] = (dp[i][j - 1] + dp[i + 1][j - 1]) % M;
                }
            } else {
                dp[i][n - i - 1] = dp[i + 1][n - i - 1];
                for (int j = n - i - 2; j >= 0; j--) {
                    dp[i][j] = (dp[i][j + 1] + dp[i + 1][j]) % M;
                }
            }
        }
        return dp[0][n];
    }

}
