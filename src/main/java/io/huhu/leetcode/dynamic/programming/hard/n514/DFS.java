package io.huhu.leetcode.dynamic.programming.hard.n514;

import java.util.Arrays;

class DFS implements Solution {

    @Override
    public int findRotateSteps(String ring, String key) {
        char[] rs = ring.toCharArray(), ks = key.toCharArray();
        int n = rs.length, m = ks.length;
        int[] size = new int[26];
        int[][] where = new int[26][n];
        for (int i = 0; i < n; i++) {
            int j = rs[i] - 'a';
            where[j][size[j]++] = i;
        }
        int[][] dp = new int[n][m];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(rs, ks, where, size, dp, 0, 0);
    }

    private int f(char[] ring, char[] key, int[][] where, int[] size, int[][] dp, int i, int j) {
        if (j == key.length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (ring[i] == key[j]) {
            dp[i][j] = 1 + f(ring, key, where, size, dp, i, j + 1);
        } else {
            int i1 = findClockwisely(where, size, i, key[j] - 'a');
            int c1 = i1 > i ? i1 - i : i1 - i + ring.length;
            int i2 = findCounterclockwisely(where, size, i, key[j] - 'a');
            int c2 = i > i2 ? i - i2 : i - i2 + ring.length;
            dp[i][j] = Math.min(c1 + f(ring, key, where, size, dp, i1, j), c2 + f(ring, key, where, size, dp, i2, j));
        }
        return dp[i][j];
    }

    private int findClockwisely(int[][] where, int[] size, int i, int v) {
        int l = 0, r = size[v] - 1, find = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (where[v][m] > i) {
                find = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return find != -1 ? where[v][find] : where[v][0];
    }

    private int findCounterclockwisely(int[][] where, int[] size, int i, int v) {
        int l = 0, r = size[v] - 1, find = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (where[v][m] < i) {
                find = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return find != -1 ? where[v][find] : where[v][size[v] - 1];
    }

}
