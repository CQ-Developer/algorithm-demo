package io.huhu.leetcode.n935;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DepthFirstSearch implements Code {

    private static final int MOD = 1000000007;
    private static final int[][] MOVE = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    @Override
    public int knightDialer(int n) {
        int ans = 0;
        int[][][] dp = new int[n][4][3];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 3 || (j != 0 && j != 2)) {
                    ans = (ans + f(i, j, n - 1, dp)) % MOD;
                }
            }
        }
        return ans;
    }

    private int f(int i, int j, int k, int[][][] dp) {
        if (k == 0) {
            return 1;
        }
        if (dp[k][i][j] != -1) {
            return dp[k][i][j];
        }
        int ans = 0;
        for (int[] mv : MOVE) {
            int _i = i + mv[0], _j = j + mv[1];
            if (_i >= 0 && _i < 4 && _j >= 0 && _j < 3) {
                if (_i != 3 || (_j != 0 && _j != 2)) {
                    ans = (ans + f(_i, _j, k - 1, dp)) % MOD;
                }
            }
        }
        return dp[k][i][j] = ans;
    }

}
