package io.huhu.leetcode.dynamic.programming.medium.n474;

final class DFS implements Solution {

    @Override
    public int findMaxForm(String[] strs, int m, int n) {
        char[][] c = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            c[i] = strs[i].toCharArray();
        }
        int[][][] f = new int[c.length][m + 1][n + 1];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    f[i][j][k] = -1;
                }
            }
        }
        return dfs(c, 0, m, n, new int[c.length][], f);
    }

    private int dfs(char[][] strs, int i, int m, int n, int[][] bc, int[][][] f) {
        if (i == strs.length) {
            return 0;
        }
        if (f[i][m][n] != -1) {
            return f[i][m][n];
        }
        f[i][m][n] = dfs(strs, i + 1, m, n, bc, f);
        int[] b = binaryCount(strs, i, bc);
        if (m >= b[0] && n >= b[1]) {
            int num = dfs(strs, i + 1, m - b[0], n - b[1], bc, f) + 1;
            if (num > f[i][m][n]) {
                f[i][m][n] = num;
            }
        }
        return f[i][m][n];
    }

    private int[] binaryCount(char[][] c, int i, int[][] bc) {
        if (bc[i] != null) {
            return bc[i];
        }
        bc[i] = new int[2];
        for (int j = 0; j < c[i].length; j++) {
            if (c[i][j] == '0') {
                bc[i][0]++;
            }
            if (c[i][j] == '1') {
                bc[i][1]++;
            }
        }
        return bc[i];
    }

}
