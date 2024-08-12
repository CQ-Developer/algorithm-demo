package io.huhu.leetcode.dynamic.programming.hard.n664;

class DP implements Solution {

    @Override
    public int strangePrinter(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i + 1 < n; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = c[i] == c[i + 1] ? 1 : 2;
        }
        dp[n - 1][n - 1] = 1;
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                if (c[l] == c[r]) {
                    dp[l][r] = dp[l + 1][r];
                } else {
                    int ans = Integer.MAX_VALUE;
                    for (int m = l; m < r; m++) {
                        ans = Math.min(ans, dp[l][m] + dp[m + 1][r]);
                    }
                    dp[l][r] = ans;
                }
            }
        }
        return dp[0][n - 1];
    }

}
