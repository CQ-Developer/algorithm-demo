package io.huhu.leetcode.dynamic.programming.medium.n313;

/**
 * <a href="https://leetcode.cn/problems/super-ugly-number/description/">超级丑数</a>
 */
class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] p = new int[primes.length];
        long[] dp = new long[n];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int k = 0;
            dp[i] = dp[p[k]] * primes[k];
            for (int j = 1; j < primes.length; j++) {
                long cur = dp[p[j]] * primes[j];
                if (cur == dp[i - 1]) {
                    p[j]++;
                    cur = dp[p[j]] * primes[j];
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
