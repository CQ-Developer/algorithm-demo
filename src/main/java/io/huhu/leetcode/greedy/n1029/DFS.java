package io.huhu.leetcode.greedy.n1029;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length, m = n >> 1;
        int[][][] dp = new int[n][m + 1][m + 1];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return f(costs, 0, m, m, dp);
    }

    private int f(int[][] costs, int i, int a, int b, int[][][] dp) {
        if (i == costs.length) {
            return 0;
        }
        if (dp[i][a][b] != -1) {
            return dp[i][a][b];
        }
        int ans = Integer.MAX_VALUE;
        if (a > 0) {
            ans = Math.min(ans, f(costs, i + 1, a - 1, b, dp) + costs[i][0]);
        }
        if (b > 0) {
            ans = Math.min(ans, f(costs, i + 1, a, b - 1, dp) + costs[i][1]);
        }
        return dp[i][a][b] = ans;
    }

}
