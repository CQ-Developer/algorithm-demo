package io.huhu.leetcode.n1227;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1;
        }
        double[] f = new double[n + 1];
        f[1] = 1;
        f[2] = 0.5;
        double pre = 0.5;
        for (int i = 3; i <= n; i++) {
            double factor = 1.0 / i;
            f[i] = factor + factor * pre;
            pre += f[i];
        }
        return f[n];
    }

}
