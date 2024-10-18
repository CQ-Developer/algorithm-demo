package io.huhu.leetcode.n688;

public class Dp implements Code {

    private static final int[][] DIR = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    @Override
    public double knightProbability(int n, int k, int row, int column) {
        double[][] p = new double[n][n];
        double[][] f = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = 1;
            }
        }
        for (int _k = 0; _k < k; _k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double ans = 0;
                    for (int[] d : DIR) {
                        int x = i + d[0], y = j + d[1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            ans += p[x][y] / 8;
                        }
                    }
                    f[i][j] = ans;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    p[i][j] = f[i][j];
                }
            }
        }
        return p[row][column];
    }

}
