package io.huhu.leetcode.dynamic.programming.hard.n10;

class DFS implements Solution {

    @Override
    public boolean isMatch(String s, String p) {
        char[] c1 = s.toCharArray(), c2 = p.toCharArray();
        return dfs(c1, c2, new int[c1.length + 1][c2.length + 1], 0, 0);
    }

    private boolean dfs(char[] s, char[] p, int[][] f, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j] == 1;
        }
        boolean ans;
        if (i == s.length) {
            if (j == p.length) {
                ans = true;
            } else {
                ans = j + 1 < p.length && p[j + 1] == '*' && dfs(s, p, f, i, j + 2);
            }
        } else if (j == p.length) {
            ans = false;
        } else {
            if (j + 1 == p.length || p[j + 1] != '*') {
                ans = (s[i] == p[j] || p[j] == '.') && dfs(s, p, f, i + 1, j + 1);
            } else {
                ans = dfs(s, p, f, i, j + 2) || ((s[i] == p[j] || p[j] == '.') && dfs(s, p, f, i + 1, j));
            }
        }
        f[i][j] = ans ? 1 : -1;
        return ans;
    }

}
