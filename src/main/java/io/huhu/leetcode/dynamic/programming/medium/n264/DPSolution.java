package io.huhu.leetcode.dynamic.programming.medium.n264;

final class DPSolution extends Solution {

    @Override
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < dp.length; i++) {
            int x = dp[a] * 2, y = dp[b] * 3, z = dp[c] * 5;
            dp[i] = Math.min(x, Math.min(y, z));
            if (dp[i] == x) {
                a++;
            }
            if (dp[i] == y) {
                b++;
            }
            if (dp[i] == z) {
                c++;
            }
        }
        return dp[n - 1];
    }

}
