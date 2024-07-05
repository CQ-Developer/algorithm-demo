package io.huhu.leetcode.dynamic.programming.medium.n474;

final class DFS implements Solution {

    @Override
    public int findMaxForm(String[] strs, int m, int n) {
        char[][] c = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            c[i] = strs[i].toCharArray();
        }
        int[][] bc = new int[strs.length][];
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        return dfs(c, 0, bc, m, n, dp);
    }

    private int dfs(char[][] s, int j, int[][] bc, int m, int n, int[][][] f) {
        if (j == s.length) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 0;
        }
        if (f[j][m][n] != 0) {
            return f[j][m][n];
        }
        int ans = 0;
        for (int i = j; i < s.length; i++) {
            int[] b = binaryCount(s, i, bc);
            if (m >= b[0] && n >= b[1]) {
                int max = dfs(s, i + 1, bc, m - b[0], n - b[1], f) + 1;
                if (max > ans) {
                    ans = max;
                }
            }
        }
        return f[j][m][n] = ans;
    }

    private int[] binaryCount(char[][] s, int i, int[][] bc) {
        if (bc[i] != null) {
            return bc[i];
        }
        int[] a = new int[2];
        for (int j = 0; j < s[i].length; j++) {
            if (s[i][j] == '0') {
                a[0]++;
            }
            if (s[i][j] == '1') {
                a[1]++;
            }
        }
        return bc[i] = a;
    }

}
