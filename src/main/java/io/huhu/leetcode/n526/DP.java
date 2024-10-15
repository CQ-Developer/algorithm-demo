package io.huhu.leetcode.n526;

class DP implements Code {

    @Override
    public int countArrangement(int n) {
        int m = 1 << n;
        int[] dp = new int[m];
        dp[m - 1] = 1;
        for (int s = m - 2; s >= 0; s--) {
            int i = Integer.bitCount(s) + 1;
            for (int j = 1; j <= n; j++) {
                int mask = 1 << (j - 1);
                if ((mask & s) == 0 && (j % i == 0 || i % j == 0)) {
                    dp[s] += dp[mask | s];
                }
            }
        }
        return dp[0];
    }

}
