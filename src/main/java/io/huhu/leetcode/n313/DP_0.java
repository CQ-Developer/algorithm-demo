package io.huhu.leetcode.n313;

class DP_0 implements Code {

    @Override
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n];
        dp[0] = 1;
        int m = primes.length;
        int[] p = new int[m];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                dp[i] = Math.min(dp[i], dp[p[j]] * primes[j]);
            }
            for (int j = 0; j < m; j++) {
                if (dp[i] == dp[p[j]] * primes[j]) {
                    p[j]++;
                }
            }
        }
        return (int) dp[n - 1];
    }

}
