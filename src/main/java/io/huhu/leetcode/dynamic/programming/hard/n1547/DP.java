package io.huhu.leetcode.dynamic.programming.hard.n1547;

import java.util.Arrays;

public class DP implements Solution {

    @Override
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int k = cuts.length;
        int[] arr = new int[k + 2];
        System.arraycopy(cuts, 0, arr, 1, k);
        arr[k + 1] = n;
        int[][] dp = new int[k + 2][k + 2];
        for (int l = k; l >= 1; l--) {
            for (int r = l; r <= k; r++) {
                dp[l][r] = Integer.MAX_VALUE;
                for (int m = l; m <= r; m++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][m - 1] + dp[m + 1][r] + arr[r + 1] - arr[l - 1]);
                }
            }
        }
        return dp[1][k];
    }

}
