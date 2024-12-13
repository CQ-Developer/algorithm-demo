package io.huhu.leetcode.n2110;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DynamicProgramming implements Solution {

    @Override
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        long res = 1;
        for (int i = 1; i < n; i++) {
            if (prices[i - 1] == prices[i] + 1) {
                f[i] += f[i - 1];
            }
            res += f[i];
        }
        return res;
    }

}
