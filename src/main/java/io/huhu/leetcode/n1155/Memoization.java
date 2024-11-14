package io.huhu.leetcode.n1155;

import io.huhu.AC;

import java.util.Arrays;

@AC
class Memoization implements Code {

    private static final int M = 1000000007;

    @Override
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int[] _dp : dp) {
            Arrays.fill(_dp, -1);
        }
        return f(n, k, target, dp);
    }

    private int f(int n, int k, int target, int[][] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 && target == 0) {
            return 1;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        int ans = 0;
        for (int _k = 1; _k <= k; _k++) {
            if (target - _k >= 0) {
                ans = (ans + f(n - 1, k, target - _k, dp)) % M;
            }
        }
        return dp[n][target] = ans;
    }

}
