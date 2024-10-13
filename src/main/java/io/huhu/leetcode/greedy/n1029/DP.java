package io.huhu.leetcode.greedy.n1029;

class DP implements Code {

    @Override
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length, m = n >> 1;
        int[][] dp = new int[m + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int a = m; a >= 0; a--) {
                for (int b = m; b >= 0; b--) {
                    int ans = Integer.MAX_VALUE;
                    if (a > 0) {
                        ans = Math.min(ans, dp[a - 1][b] + costs[i][0]);
                    }
                    if (b > 0) {
                        ans = Math.min(ans, dp[a][b - 1] + costs[i][1]);
                    }
                    dp[a][b] = ans;
                }
            }
        }
        return dp[m][m];
    }

}
