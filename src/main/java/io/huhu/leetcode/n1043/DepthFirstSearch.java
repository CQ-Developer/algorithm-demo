package io.huhu.leetcode.n1043;

import java.util.Arrays;

class DepthFirstSearch implements Code {

    @Override
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(arr, k, dp, n - 1);
    }

    private int f(int[] arr, int k, int[] dp, int i) {
        if (i < 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = 0, max = 0;
        for (int j = i; j >= 0 && i - j + 1 <= k; j--) {
            max = Math.max(max, arr[j]);
            ans = Math.max(ans, max * (i - j + 1) + f(arr, k, dp, j - 1));
        }
        return dp[i] = ans;
    }

}
