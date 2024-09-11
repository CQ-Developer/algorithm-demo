package io.huhu.leetcode.dynamic.programming.hard.n629;

class DP implements Solution {

    private static final int M = (int) 1E9 + 7;

    @Override
    public int kInversePairs(int n, int k) {
        int[] up = new int[k + 1];
        int[] dp = new int[k + 1];
        up[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[0] = 1;
            long window = 1;
            for (int j = 1; j <= k; j++) {
                window += up[j];
                if (j >= i) {
                    window -= up[j - i];
                }
                dp[j] = (int) (window % M);
            }
            for (int p = 0; p <= k; p++) {
                up[p] = dp[p];
                dp[p] = 0;
            }
        }
        return up[k];
    }

}
