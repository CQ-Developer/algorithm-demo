package io.huhu.leetcode.dynamic.programming.medium.n91;

class DP extends Solution {

    @Override
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < s.length() && ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0')) <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

}
