package io.huhu.leetcode.n2110;

import io.huhu.AC;

@AC
class DynamicProgramming implements Solution {

    @Override
    public long getDescentPeriods(int[] prices) {
        long res = 1;
        int pre = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] == prices[i] + 1) {
                pre++;
            } else {
                pre = 1;
            }
            res += pre;
        }
        return res;
    }

}
