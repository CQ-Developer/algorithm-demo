package io.huhu.leetcode.dynamic.programming.medium.n688;

final class DFS implements Solution {

    @Override
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] f = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = 0; x <= k; x++) {
                    f[i][j][x] = -1;
                }
            }
        }
        return dfs(n, k, row, column, f);
    }

    private double dfs(int n, int k, int i, int j, double[][][] f) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (f[i][j][k] != -1) {
            return f[i][j][k];
        }
        double ans = 0;
        if (k == 0) {
            ans = 1;
        } else {
            ans += dfs(n, k - 1, i - 2, j + 1, f) / 8;
            ans += dfs(n, k - 1, i - 1, j + 2, f) / 8;
            ans += dfs(n, k - 1, i + 1, j + 2, f) / 8;
            ans += dfs(n, k - 1, i + 2, j + 1, f) / 8;
            ans += dfs(n, k - 1, i + 2, j - 1, f) / 8;
            ans += dfs(n, k - 1, i + 1, j - 2, f) / 8;
            ans += dfs(n, k - 1, i - 1, j - 2, f) / 8;
            ans += dfs(n, k - 1, i - 2, j - 1, f) / 8;
        }
        return f[i][j][k] = ans;
    }

}
