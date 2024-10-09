package io.huhu.leetcode.n375;

class DFS implements Code {

    @Override
    public int getMoneyAmount(int n) {
        return f(1, n, new int[n + 1][n + 1]);
    }

    /**
     * 在l...r范围上猜错需要付出的代价
     */
    private int f(int l, int r, int[][] dp) {
        if (l >= r) {
            return 0;
        }
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            ans = Math.min(ans, Math.max(f(l, i - 1, dp), f(i + 1, r, dp)) + i);
        }
        return dp[l][r] = ans;
    }

}
