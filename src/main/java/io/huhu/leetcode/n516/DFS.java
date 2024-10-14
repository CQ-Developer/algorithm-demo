package io.huhu.leetcode.n516;

class DFS implements Code {

    @Override
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                dp[l][r] = -1;
            }
        }
        return f(c, 0, n - 1, dp);
    }

    private int f(char[] s, int l, int r, int[][] dp) {
        if (l == r) {
            return 1;
        }
        if (l + 1 == r) {
            return s[l] == s[r] ? 2 : 1;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        int ans = Math.max(f(s, l + 1, r, dp), f(s, l, r - 1, dp));
        if (s[l] == s[r]) {
            ans = Math.max(ans, f(s, l + 1, r - 1, dp) + 2);
        }
        return dp[l][r] = ans;
    }

}
