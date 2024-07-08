package io.huhu.leetcode.dynamic.programming.hard.n87;

final class DFS implements Solution {

    @Override
    public boolean isScramble(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int n = c1.length;
        return dfs(c1, 0, c2, 0, n, new int[n][n][n + 1]);
    }

    private boolean dfs(char[] s1, int i, char[] s2, int j, int n, int[][][] f) {
        if (n == 1) {
            return s1[i] == s2[j];
        }
        if (f[i][j][n] != 0) {
            return f[i][j][n] == 1;
        }
        boolean ans = false;
        for (int k = 1; k < n && !ans; k++) {
            ans = (dfs(s1, i, s2, j, k, f) && dfs(s1, i + k, s2, j + k, n - k, f)) || (dfs(s1, i, s2, j + n - k, k, f) && dfs(s1, i + k, s2, j, n - k, f));
        }
        f[i][j][n] = ans ? 1 : -1;
        return ans;
    }

}
