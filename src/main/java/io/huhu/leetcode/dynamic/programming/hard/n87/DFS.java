package io.huhu.leetcode.dynamic.programming.hard.n87;

final class DFS implements Solution {

    @Override
    public boolean isScramble(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int n = c1.length;
        int[][][] f = new int[n][n][n + 1];
        return dfs(c1, 0, c2, 0, n, f);
    }

    private boolean dfs(char[] s1, int l1, char[] s2, int l2, int n, int[][][] f) {
        if (n == 1) {
            return s1[l1] == s2[l2];
        }
        if (f[l1][l2][n] != 0) {
            return f[l1][l2][n] == 1;
        }
        boolean ans = false;
        for (int k = 1; k < n && !ans; k++) {
            if (dfs(s1, l1, s2, l2, k, f) && dfs(s1, l1 + k, s2, l2 + k, n - k, f)) {
                ans = true;
            }
        }
        for (int k = 1, i = l1 + 1, j = l2 + n - 1; k < n && !ans; k++, i++, j--) {
            if (dfs(s1, l1, s2, j, k, f) && dfs(s1, i, s2, l2, n - k, f)) {
                ans = true;
            }
        }
        f[l1][l2][n] = ans ? 1 : -1;
        return ans;
    }

}
