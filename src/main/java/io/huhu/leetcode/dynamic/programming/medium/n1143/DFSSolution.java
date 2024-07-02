package io.huhu.leetcode.dynamic.programming.medium.n1143;

final class DFSSolution extends Solution {

    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray(), c2 = text2.toCharArray();
        int n = c1.length, m = c2.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = -1;
            }
        }
        return dfs(c1, n, c2, m, f);
    }

    private int dfs(char[] s1, int i, char[] s2, int j, int[][] f) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (f[i][j] != -1) {
            return f[i][j];
        }
        if (s1[i - 1] == s2[j - 1]) {
            return f[i][j] = dfs(s1, i - 1, s2, j - 1, f) + 1;
        }
        return f[i][j] = Math.max(dfs(s1, i - 1, s2, j, f), dfs(s1, i, s2, j - 1, f));
    }

}
