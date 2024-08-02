package io.huhu.leetcode.dynamic.programming.hard.n10;

class DP implements Solution {

    @Override
    public boolean isMatch(String s, String p) {
        char[] c1 = s.toCharArray(), c2 = p.toCharArray();
        return dp(c1, c1.length, c2, c2.length);
    }

    private boolean dp(char[] s, int n, char[] p, int m) {
        boolean[][] f = new boolean[n + 1][m + 1];
        f[n][m] = true;
        for (int j = m - 1; j >= 0; j--) {
            f[n][j] = j + 1 < m && p[j + 1] == '*' && f[n][j + 2];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (j + 1 == m || p[j + 1] != '*') {
                    f[i][j] = (s[i] == p[j] || p[j] == '.') && f[i + 1][j + 1];
                } else {
                    f[i][j] = f[i][j + 2] || ((s[i] == p[j] || p[j] == '.') && f[i + 1][j]);
                }
            }
        }
        return f[0][0];
    }

}
