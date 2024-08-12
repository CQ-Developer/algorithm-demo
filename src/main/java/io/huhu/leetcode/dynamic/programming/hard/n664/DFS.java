package io.huhu.leetcode.dynamic.programming.hard.n664;

import java.util.Arrays;

class DFS implements Solution {

    @Override
    public int strangePrinter(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] f = new int[n][n];
        for (int[] a : f) {
            Arrays.fill(a, -1);
        }
        return dfs(c, 0, n - 1, f);
    }

    private int dfs(char[] s, int l, int r, int[][] f) {
        if (l == r) {
            return 1;
        }
        if (l + 1 == r) {
            return s[l] == s[r] ? 1 : 2;
        }
        if (f[l][r] != -1) {
            return f[l][r];
        }
        if (s[l] == s[r]) {
            f[l][r] = dfs(s, l + 1, r, f);
        } else {
            int ans = Integer.MAX_VALUE;
            for (int m = l; m < r; m++) {
                ans = Math.min(ans, dfs(s, l, m, f) + dfs(s, m + 1, r, f));
            }
            f[l][r] = ans;
        }
        return f[l][r];
    }

}
