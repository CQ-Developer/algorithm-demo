package io.huhu.leetcode.n1639;

class DynamicProgramming implements Code {

    @Override
    public int countSubstrings(String s, String t) {
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        int m = sc.length, n = tc.length, ans = 0;
        int[][] f = new int[m + 1][n + 1], g = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sc[i] == tc[j]) {
                    f[i + 1][j + 1] = f[i][j] + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (sc[i] == tc[j]) {
                    g[i][j] = g[i + 1][j + 1] + 1;
                } else {
                    ans += (f[i][j] + 1) * (g[i + 1][j + 1] + 1);
                }
            }
        }
        return ans;
    }

}
