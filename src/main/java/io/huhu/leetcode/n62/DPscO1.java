package io.huhu.leetcode.n62;

class DPscO1 implements Code {

    @Override
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            dp[j] = 1;
        }
        for (int i = m - 1; i >= 1; i--) {
            for (int j = n - 1; j >= 1; j--) {
                dp[j] += dp[j + 1];
            }
        }
        return dp[1];
    }

}
