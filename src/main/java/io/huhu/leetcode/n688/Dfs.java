package io.huhu.leetcode.n688;

import java.util.Arrays;

class Dfs implements Code {

    @Override
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] m = new double[k + 1][n][n];
        for (double[][] a : m) {
            for (double[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return f(n, k, row, column, m);
    }

    public double f(int n, int k, int i, int j, double[][][] m) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (m[k][i][j] != -1) {
            return m[k][i][j];
        }
        double ans = 0;
        ans += f(n, k - 1, i + 1, j + 2, m) / 8;
        ans += f(n, k - 1, i + 1, j - 2, m) / 8;
        ans += f(n, k - 1, i - 1, j + 2, m) / 8;
        ans += f(n, k - 1, i - 1, j - 2, m) / 8;
        ans += f(n, k - 1, i + 2, j + 1, m) / 8;
        ans += f(n, k - 1, i + 2, j - 1, m) / 8;
        ans += f(n, k - 1, i - 2, j + 1, m) / 8;
        ans += f(n, k - 1, i - 2, j - 1, m) / 8;
        return m[k][i][j] = ans;
    }

}
