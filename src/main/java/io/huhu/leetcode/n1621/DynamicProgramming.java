package io.huhu.leetcode.n1621;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    private static final int M = 1_000_000_007;

    @Override
    public int numberOfSets(int n, int k) {
        int[] f0 = new int[k + 1], f1 = new int[k + 1];
        f0[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 0; j--) {
                f0[j] = (f0[j] + f1[j]) % M;
                if (j > 0) {
                    f1[j] = (f1[j] + f0[j - 1]) % M;
                    f1[j] = (f1[j] + f1[j - 1]) % M;
                }
            }
        }
        return (f0[k] + f1[k]) % M;
    }

}
