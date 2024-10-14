package io.huhu.leetcode.n516;

class DP implements Code {

    @Override
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int ld = 0;
            dp[i] = 1;
            if (i + 1 < n) {
                ld = dp[i + 1];
                dp[i + 1] = c[i] == c[i + 1] ? 2 : 1;
            }
            for (int j = i + 2; j < n; j++) {
                int t = dp[j];
                if (c[i] == c[j]) {
                    dp[j] = ld + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                ld = t;
            }
        }
        return dp[n - 1];
    }

}
