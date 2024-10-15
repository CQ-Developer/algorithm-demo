package io.huhu.leetcode.n526;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int countArrangement(int n) {
        int[][] dp = new int[n + 1][1 << (n + 1)];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(n, 0, n, dp);
    }

    private int f(int i, int j, int n, int[][] dp) {
        if (i == 0) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        for (int num = 1; num <= n; num++) {
            if (((1 << num) & j) == 0 && (i % num == 0 || num % i == 0)) {
                ans += f(i - 1, (1 << num) | j, n, dp);
            }
        }
        return dp[i][j] = ans;
    }

}
