package io.huhu.leetcode.n935;

import io.huhu.AC;

@AC
class DynamicProgrammingA implements Code {

    private static final int M = 1000000007;

    @Override
    public int knightDialer(int n) {
        long[][] f = new long[n + 1][10];
        for (int j = 0; j <= 9; j++) {
            f[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            f[i][0] = (f[i - 1][4] + f[i - 1][6]) % M;
            f[i][1] = (f[i - 1][6] + f[i - 1][8]) % M;
            f[i][2] = (f[i - 1][7] + f[i - 1][9]) % M;
            f[i][3] = (f[i - 1][4] + f[i - 1][8]) % M;
            f[i][4] = (f[i - 1][0] + f[i - 1][3] + f[i - 1][9]) % M;
            f[i][6] = (f[i - 1][0] + f[i - 1][1] + f[i - 1][7]) % M;
            f[i][7] = (f[i - 1][2] + f[i - 1][6]) % M;
            f[i][8] = (f[i - 1][1] + f[i - 1][3]) % M;
            f[i][9] = (f[i - 1][2] + f[i - 1][4]) % M;
        }
        int ans = 0;
        for (int j = 0; j <= 9; j++) {
            ans = (ans + (int) f[n][j]) % M;
        }
        return ans;
    }

}
