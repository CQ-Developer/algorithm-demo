package io.huhu.leetcode.n91;

class DP implements Code {

    @Override
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (c[i] != '0') {
                dp[i] += dp[i + 1];
                if (i + 1 < n && (c[i] - '0') * 10 + (c[i + 1] - '0') <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

}
