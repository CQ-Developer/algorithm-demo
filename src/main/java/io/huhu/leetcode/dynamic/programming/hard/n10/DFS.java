package io.huhu.leetcode.dynamic.programming.hard.n10;

class DFS implements Solution {

    @Override
    public boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean dfs(char[] s, int i, char[] p, int j) {
        if (i == s.length) {
            return j == p.length || j + 1 < p.length && p[j + 1] == '*' && dfs(s, i, p, j + 2);
        }
        if (j == p.length) {
            return false;
        }
        return false;
    }

}
