package io.huhu.leetcode.n808;

class DepthFirstSearch implements Code {

    @Override
    public double soupServings(int n) {
        n = (n + 24) / 25;
        if (n >= 179) {
            return 1;
        }
        return f(n, n, new double[n + 1][n + 1]);
    }

    private double f(int a, int b, double[][] m) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1;
        }
        if (b <= 0) {
            return 0;
        }
        if (m[a][b] == 0) {
            m[a][b] = 0.25 * (f(a - 4, b, m) + f(a - 3, b - 1, m) + f(a - 2, b - 2, m) + f(a - 1, b - 3, m));
        }
        return m[a][b];
    }

}
