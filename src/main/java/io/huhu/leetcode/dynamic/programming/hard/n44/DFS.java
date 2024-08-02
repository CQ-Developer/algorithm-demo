package io.huhu.leetcode.dynamic.programming.hard.n44;

class DFS implements Solution {

    @Override
    public boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean dfs(char[] s, char[] p, int i, int j) {
        if (i == s.length) {
            if (j == p.length) {
                return true;
            } else {
                return p[j] == '*' && dfs(s, p, i, j + 1);
            }
        } else if (j == p.length) {
            return false;
        } else {
            if (p[j] != '*') {
                return (p[j] == s[i] || p[j] == '?') && dfs(s, p, i + 1, j + 1);
            } else {
                return dfs(s, p, i + 1, j) || dfs(s, p, i, j + 1);
            }
        }
    }

}
