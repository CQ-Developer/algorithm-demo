package io.huhu.leetcode.dynamic.programming.medium.n97;

final class DFS implements Solution {

    @Override
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        if (c1.length + c2.length != c3.length) {
            return false;
        }
        return dfs(c1, 0, c2, 0, c3, 0, new boolean[c1.length + 1][c2.length + 1]);
    }

    private boolean dfs(char[] s1, int i, char[] s2, int j, char[] s3, int k, boolean[][] visited) {
        if (k == s3.length) {
            return true;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (i < s1.length && s1[i] == s3[k] && dfs(s1, i + 1, s2, j, s3, k + 1, visited)) {
            return true;
        }
        if (j < s2.length && s2[j] == s3[k] && dfs(s1, i, s2, j + 1, s3, k + 1, visited)) {
            return true;
        }
        return false;
    }

}
