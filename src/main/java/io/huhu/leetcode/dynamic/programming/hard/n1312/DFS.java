package io.huhu.leetcode.dynamic.programming.hard.n1312;

import java.util.Arrays;

class DFS implements Solution {

    @Override
    public int minInsertions(String s) {
        var c = s.toCharArray();
        int[][] f = new int[c.length][c.length];
        for (int[] a : f) {
            Arrays.fill(a, -1);
        }
        return dfs(c, 0, c.length - 1, f);
    }

    private int dfs(char[] s, int l, int r, int[][] f) {
        if (l >= r) {
            return 0;
        }
        if (f[l][r] != -1) {
            return f[l][r];
        }
        if (s[l] == s[r]) {
            f[l][r] = dfs(s, l + 1, r - 1, f);
        } else {
            int a = dfs(s, l + 1, r, f) + 1;
            int b = dfs(s, l, r - 1, f) + 1;
            f[l][r] = Integer.min(a, b);
        }
        return f[l][r];
    }

}
