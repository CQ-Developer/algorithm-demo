package io.huhu.leetcode.dynamic.programming.hard.n879;

final class DFS implements Solution {

    @Override
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] f = new int[group.length][n + 1][minProfit + 1];
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    f[i][j][k] = -1;
                }
            }
        }
        return dfs(n, minProfit, group, profit, 0, f);
    }

    private int dfs(int n, int m, int[] g, int[] p, int i, int[][][] f) {
        if (i == g.length || n <= 0) {
            return m == 0 ? 1 : 0;
        }
        if (f[i][n][m] != -1) {
            return f[i][n][m];
        }
        int ans = dfs(n, m, g, p, i + 1, f);
        if (n >= g[i]) {
            ans += dfs(n - g[i], Math.max(0, m - p[i]), g, p, i + 1, f);
        }
        return f[i][n][m] = ans % 1000000007;
    }

}
