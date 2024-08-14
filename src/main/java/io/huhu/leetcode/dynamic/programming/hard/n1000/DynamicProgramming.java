package io.huhu.leetcode.dynamic.programming.hard.n1000;

class DynamicProgramming implements Solution {

    @Override
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int l = n - 2; l >= 0; l--) {
            for (int r = l + 1; r < n; r++) {
                int ans = Integer.MAX_VALUE;
                for (int i = l; i < r; i += k - 1) {
                    ans = Math.min(ans, dp[l][i] + dp[i + 1][r]);
                }
                if ((r - l) % (k - 1) == 0) {
                    ans += p[r + 1] - p[l];
                }
                dp[l][r] = ans;
            }
        }
        return dp[0][n - 1];
    }

}
