package io.huhu.leetcode.dynamic.programming.medium.n688;

final class DP implements Solution {

    @Override
    public double knightProbability(int n, int k, int row, int column) {
        int[][] ds = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        double[][][] f = new double[k + 1][n][n];
        for (int x = 0; x <= k; x++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (x == 0) {
                        f[0][i][j] = 1;
                    } else {
                        for (int[] d : ds) {
                            int a = i + d[0], b = j + d[1];
                            if (a >= 0 && a < n && b >= 0 && b < n) {
                                f[x][i][j] += f[x - 1][a][b] / 8;
                            }
                        }
                    }
                }
            }
        }
        return f[k][row][column];
    }

}
