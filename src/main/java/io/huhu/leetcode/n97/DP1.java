package io.huhu.leetcode.n97;

class DP1 implements Code {

    @Override
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int m = c1.length, n = c2.length;
        if (m + n != c3.length) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j <= n && c2[j - 1] == c3[j - 1]; j++) {
            dp[j] = true;
        }
        for (int i = 1; i <= m; i++) {
            dp[0] = dp[0] && c1[i - 1] == c3[i - 1];
            for (int j = 1; j <= n; j++) {
                dp[j] = (c1[i - 1] == c3[i + j - 1] && dp[j]) || (c2[j - 1] == c3[i + j - 1] && dp[j - 1]);
            }
        }
        return dp[n];
    }

}
