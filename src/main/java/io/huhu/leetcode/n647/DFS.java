package io.huhu.leetcode.n647;

class DFS implements Code {

    @Override
    public int countSubstrings(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (f(c, i, j, dp)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean f(char[] c, int l, int r, int[][] dp) {
        if (dp[l][r] != 0) {
            return dp[l][r] == 1;
        }
        boolean ans;
        if (l == r) {
            ans = true;
        } else if (l + 1 == r) {
            ans = c[l] == c[r];
        } else {
            ans = c[l] == c[r] && f(c, l + 1, r - 1, dp);
        }
        dp[l][r] = ans ? 1 : -1;
        return ans;
    }

}
