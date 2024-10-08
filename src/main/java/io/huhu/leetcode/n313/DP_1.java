package io.huhu.leetcode.n313;

class DP_1 implements Code {

    @Override
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n];
        dp[0] = 1;
        int m = primes.length;
        int[] p = new int[m];
        for (int i = 1; i < n; i++) {
            int k = 0;
            dp[i] = dp[p[k]] * primes[k];
            for (int j = 1; j < m; j++) {
                long cur = dp[p[j]] * primes[j];
                if (cur == dp[i - 1]) {
                    cur = dp[++p[j]] * primes[j];
                }
                if (cur < dp[i]) {
                    dp[i] = cur;
                    k = j;
                }
            }
            p[k]++;
        }
        return (int) dp[n - 1];
    }

}
