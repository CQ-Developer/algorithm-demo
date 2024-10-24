package io.huhu.leetcode.n808;

class DynamicProgramming implements Code {

    @Override
    public double soupServings(int n) {
        n = (n + 24) / 25;
        if (n >= 179) {
            return 1;
        }
        double[][] f = new double[n + 1][n + 1];
        f[0][0] = 0.5;
        for (int j = 1; j <= n; j++) {
            f[0][j] = 1.0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = 0.25 * (f[Math.max(i - 4, 0)][j] + f[Math.max(i - 3, 0)][j - 1] + f[Math.max(i - 2, 0)][Math.max(j - 2, 0)] + f[i - 1][Math.max(j - 3, 0)]);
            }
        }
        return f[n][n];
    }

}
