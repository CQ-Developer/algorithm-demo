package io.huhu.leetcode.n1621;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    private static final int M = 1_000_000_007;

    @Override
    public int numberOfSets(int n, int k) {
        int[][] f0 = new int[n][k + 1], f1 = new int[n][k + 1];
        f0[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                f0[i][j] = (f0[i - 1][j] + f1[i - 1][j]) % M;
                f1[i][j] = f1[i - 1][j];
                if (j > 0) {
                    f1[i][j] = (f1[i][j] + f0[i - 1][j - 1]) % M;
                    f1[i][j] = (f1[i][j] + f1[i - 1][j - 1]) % M;
                }
            }
        }
        return (f0[n - 1][k] + f1[n - 1][k]) % M;
    }

}
