package io.huhu.leetcode.dynamic.programming.medium.n688;

final class DP implements Solution {

    @Override
    public double knightProbability(int n, int k, int row, int column) {
        int[][] ds = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        double[][] f = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = 1;
            }
        }
        for (int x = 1; x <= k; x++) {
            double[][] c = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d : ds) {
                        int a = i + d[0], b = j + d[1];
                        if (a >= 0 && a < n && b >= 0 && b < n) {
                            c[i][j] += f[a][b] / 8;
                        }
                    }
                }
            }
            f = c;
        }
        return f[row][column];
    }

}
