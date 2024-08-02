package io.huhu.leetcode.dynamic.programming.hard.n44;

class DFS implements Solution {

    @Override
    public boolean isMatch(String s, String p) {
        char[] c1 = s.toCharArray(), c2 = p.toCharArray();
        return dfs(c1, c2, 0, 0, new int[c1.length + 1][c2.length + 1]);
    }

    private boolean dfs(char[] s, char[] p, int i, int j, int[][] f) {
        if (f[i][j] != 0) {
            return f[i][j] == 1;
        }
        boolean ans;
        if (i == s.length) {
            if (j == p.length) {
                ans = true;
            } else {
                ans = p[j] == '*' && dfs(s, p, i, j + 1, f);
            }
        } else if (j == p.length) {
            ans = false;
        } else {
            if (p[j] != '*') {
                ans = (p[j] == s[i] || p[j] == '?') && dfs(s, p, i + 1, j + 1, f);
            } else {
                ans = dfs(s, p, i + 1, j, f) || dfs(s, p, i, j + 1, f);
            }
        }
        f[i][j] = ans ? 1 : -1;
        return ans;
    }

}
