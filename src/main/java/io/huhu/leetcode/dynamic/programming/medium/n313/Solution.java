package io.huhu.leetcode.dynamic.programming.medium.n313;

/**
 * <a href="https://leetcode.cn/problems/super-ugly-number/description/">超级丑数</a>
 */
class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] points = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                int t = Math.min(dp[i], dp[points[j]] * primes[j]);
                // 处理越界问题
                if (t < 0) {
                    continue;
                }
                dp[i] = t;
            }
            for (int j = 0; j < points.length; j++) {
                if (dp[i] == dp[points[j]] * primes[j]) {
                    points[j]++;
                }
            }
        }
        return dp[n - 1];
    }

}
