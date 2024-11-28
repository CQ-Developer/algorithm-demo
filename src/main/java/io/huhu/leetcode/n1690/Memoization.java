package io.huhu.leetcode.n1690;

import java.util.Arrays;

class Memoization implements Code {

    @Override
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] left = new int[n + 1];
        for (int i = 0; i < n; i++) {
            left[i + 1] = left[i] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(left, dp, 0, n - 1);
    }

    private int f(int[] left, int[][] dp, int l, int r) {
        if (l >= r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        return dp[l][r] = Math.max(left[r + 1] - left[l + 1] - f(left, dp, l + 1, r), left[r] - left[l] - f(left, dp, l, r - 1));
    }

}
