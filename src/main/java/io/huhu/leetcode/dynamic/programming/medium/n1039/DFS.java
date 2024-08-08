package io.huhu.leetcode.dynamic.programming.medium.n1039;

class DFS implements Solution {

    @Override
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        return dfs(values, 0, n - 1, new int[n][n]);
    }

    private int dfs(int[] v, int l, int r, int[][] f) {
        if (l == r || l + 1 == r) {
            return 0;
        }
        if (f[l][r] != 0) {
            return f[l][r];
        }
        f[l][r] = Integer.MAX_VALUE;
        for (int m = l + 1; m < r; m++) {
            f[l][r] = Integer.min(f[l][r], dfs(v, l, m, f) + dfs(v, m, r, f) + v[l] * v[m] * v[r]);
        }
        return f[l][r];
    }

}
