package io.huhu.leetcode.n1155;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    private static final int M = 1000000007;

    @Override
    public int numRollsToTarget(int n, int k, int target) {
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                int ans = 0;
                for (int _k = 1; _k <= k; _k++) {
                    if (j - _k >= 0) {
                        ans = (ans + f[i - 1][j - _k]) % M;
                    }
                }
                f[i][j] = ans;
            }
        }
        return f[n][target];
    }

}
