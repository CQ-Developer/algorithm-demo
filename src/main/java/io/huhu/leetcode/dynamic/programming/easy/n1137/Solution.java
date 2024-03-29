package io.huhu.leetcode.dynamic.programming.easy.n1137;

/**
 * <a href="https://leetcode.cn/problems/n-th-tribonacci-number/description/">第N个泰波那契数</a>
 */
class Solution {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        int t0 = 0, t1 = 1, t2 = 1, tn = 0;
        for (int i = 3; i <= n; i++) {
            tn = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }
        return tn;
    }

}
