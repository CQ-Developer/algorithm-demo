package io.huhu.leetcode.n837;

import java.util.Arrays;

/**
 * TLE
 */
class DepthFirstSearch implements Code {

    @Override
    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[k];
        Arrays.fill(dp, -1);
        return f(n, k, maxPts, 0, dp);
    }

    private double f(int n, int k, int p, int c, double[] dp) {
        if (c >= k) {
            return c <= n ? 1 : 0;
        }
        if (dp[c] != -1) {
            return dp[c];
        }
        double ans = 0;
        for (int i = 1; i <= p && i + c <= n; i++) {
            ans += f(n, k, p, c + i, dp);
        }
        return dp[c] = ans / p;
    }

}
