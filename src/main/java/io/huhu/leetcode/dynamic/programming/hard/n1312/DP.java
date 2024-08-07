package io.huhu.leetcode.dynamic.programming.hard.n1312;

class DP implements Solution {

    @Override
    public int minInsertions(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        for (int l = n - 1; l >= 0; l--) {
            for (int r = l + 1; r < n; r++) {
                if (c[l] == c[r]) {
                    dp[l][r] = dp[l + 1][r - 1];
                } else {
                    dp[l][r] = Integer.min(dp[l + 1][r] + 1, dp[l][r - 1] + 1);
                }
            }
        }
        return dp[0][n - 1];
    }

}
