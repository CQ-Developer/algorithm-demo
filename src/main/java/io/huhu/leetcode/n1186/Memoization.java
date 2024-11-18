package io.huhu.leetcode.n1186;

import io.huhu.AC;

import java.util.Arrays;

@AC
class Memoization implements Code {

    @Override
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        for (int[] _dp : dp) {
            Arrays.fill(_dp, Integer.MIN_VALUE);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(f(arr, dp, i, 0), f(arr, dp, i, 1)));
        }
        return ans;
    }

    private int f(int[] arr, int[][] dp, int i, int j) {
        if (i < 0) {
            return Integer.MIN_VALUE / 2;
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        if (j == 0) {
            return dp[i][j] = Math.max(f(arr, dp, i - 1, 0), 0) + arr[i];
        }
        return dp[i][j] = Math.max(f(arr, dp, i - 1, 1) + arr[i], f(arr, dp, i - 1, 0));
    }

}
