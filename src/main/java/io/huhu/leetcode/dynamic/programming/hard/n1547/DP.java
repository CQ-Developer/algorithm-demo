package io.huhu.leetcode.dynamic.programming.hard.n1547;

import java.util.Arrays;

class DP implements Solution {

    @Override
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[] arr = new int[m + 2];
        System.arraycopy(cuts, 0, arr, 1, m);
        arr[m + 1] = n;
        int[][] dp = new int[m + 2][m + 2];
        for (int i = 1; i <= m; i++) {
            dp[i][i] = arr[i + 1] - arr[i - 1];
        }
        for (int l = m - 1; l >= 1; l--) {
            for (int r = l + 1; r <= m; r++) {
                int t = Integer.MAX_VALUE;
                for (int k = l; k <= r; k++) {
                    t = Math.min(t, dp[l][k - 1] + dp[k + 1][r]);
                    dp[l][r] = arr[r + 1] - arr[l - 1] + t;
                }
            }
        }
        return dp[1][m];
    }

}
