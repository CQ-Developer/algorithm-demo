package io.huhu.leetcode.n1227;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1;
        }
        double pre = 0.5, cur = pre;
        for (int i = 3; i <= n; i++) {
            double factor = 1.0 / i;
            cur = factor + factor * pre;
            pre += cur;
        }
        return cur;
    }

}
