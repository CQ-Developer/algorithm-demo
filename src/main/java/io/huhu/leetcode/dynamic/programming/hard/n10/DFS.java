package io.huhu.leetcode.dynamic.programming.hard.n10;

class DFS implements Solution {

    @Override
    public boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean dfs(char[] s, char[] p, int i, int j) {
        if (i == s.length) {
            return j == p.length || j + 1 < p.length && p[j + 1] == '*' && dfs(s, p, i, j + 2);
        }
        if (j == p.length) {
            return false;
        }
        if (j + 1 == p.length || p[j + 1] != '*') {
            return (s[i] == p[j] || p[j] == '.') && dfs(s, p, i + 1, j + 1);
        }
        boolean a = dfs(s, p, i, j + 2);
        boolean b = (s[i] == p[j] || p[j] == '.') && dfs(s, p, i + 1, j);
        return a || b;
    }

}
