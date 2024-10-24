package io.huhu.leetcode.n799;

class DynamicProgramming implements Code {

    @Override
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] n = new double[query_row + 1];
        double[] f = new double[query_row + 1];
        f[0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[j] > 1) {
                    double overflow = (f[j] - 1) / 2;
                    n[j] += overflow;
                    n[j + 1] += overflow;
                }
            }
            for (int j = 0; j <= query_row; j++) {
                f[j] = n[j];
                n[j] = 0;
            }
        }
        return Math.min(1.0, f[query_glass]);
    }

}
