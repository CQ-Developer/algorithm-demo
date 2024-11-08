package io.huhu.leetcode.n1039;

import java.util.Arrays;

class DepthFirstSearch implements Code {

    @Override
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(values, dp, 0, n - 1);
    }

    private int f(int[] v, int[][] dp, int l, int r) {
        if (l == r || l + 1 == r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for (int m = l + 1; m < r; m++) {
            ans = Math.min(ans, f(v, dp, l, m) + f(v, dp, m, r) + v[l] * v[m] * v[r]);
        }
        return dp[l][r] = ans;
    }

}
