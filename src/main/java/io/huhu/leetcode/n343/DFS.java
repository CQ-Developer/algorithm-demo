package io.huhu.leetcode.n343;

class DFS implements Code {

    @Override
    public int integerBreak(int n) {
        return f(n, new int[n + 1]);
    }

    private int f(int n, int[] dp) {
        if (n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = 1;
        for (int i = 1; i <= n / 2; i++) {
            ans = Math.max(ans, Math.max(i * (n - i), i * f(n - i, dp)));
        }
        return dp[n] = ans;
    }

}
