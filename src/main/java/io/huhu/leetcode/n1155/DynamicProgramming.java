package io.huhu.leetcode.n1155;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    private static final int M = 1000000007;

    @Override
    public int numRollsToTarget(int n, int k, int target) {
        int[] f = new int[target + 1];
        for (int i = 0; i < n; i++) {
            f[0] = i == 0 ? 1 : 0;
            for (int j = target; j >= 1; j--) {
                f[j] = 0;
                for (int _k = 1; _k <= k; _k++) {
                    if (j - _k >= 0) {
                        f[j] = (f[j] + f[j - _k]) % M;
                    }
                }
            }
        }
        return f[target];
    }

}
