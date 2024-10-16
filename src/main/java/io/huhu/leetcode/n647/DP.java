package io.huhu.leetcode.n647;

class DP implements Code {

    @Override
    public int countSubstrings(String s) {
        char[] c = s.toCharArray();
        int n = c.length, ans = 0;
        boolean[][] dp = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int l = 0; l <= r; l++) {
                if (c[l] == c[r] && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

}
