package io.huhu.leetcode.dynamic.programming.medium.n639;

final class DPSolution extends Solution {

    @Override
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        long[] dp = new long[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (cs[i] == '0') {
                continue;
            }
            dp[i] = dp[i + 1] * (cs[i] == '*' ? 9 : 1);
            if (i + 1 >= n) {
                continue;
            }
            if (cs[i] == '*') {
                if (cs[i + 1] == '*') {
                    dp[i] += dp[i + 2] * 15;
                } else {
                    dp[i] += dp[i + 2] * (cs[i + 1] <= '6' ? 2 : 1);
                }
            } else {
                if (cs[i + 1] == '*') {
                    dp[i] += dp[i + 2] * (cs[i] == '1' ? 9 : cs[i] == '2' ? 6 : 0);
                } else {
                    dp[i] += dp[i + 2] * ((cs[i] - '0') * 10 + (cs[i + 1] - '0') <= 26 ? 1 : 0);
                }
            }
            dp[i] %= 1000000007;
        }
        return (int) dp[0];
    }

}
