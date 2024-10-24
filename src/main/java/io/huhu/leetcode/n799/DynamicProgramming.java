package io.huhu.leetcode.n799;

class DynamicProgramming implements Code {

    @Override
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] f = new double[query_row + 1][query_row + 1];
        f[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[i][j] > 1) {
                    double overflow = (f[i][j] - 1) / 2;
                    f[i + 1][j] += overflow;
                    f[i + 1][j + 1] += overflow;
                }
            }
        }
        return Math.min(1, f[query_row][query_glass]);
    }

}
