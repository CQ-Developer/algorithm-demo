package io.huhu.leetcode.dynamic.programming.hard.n730;

import java.util.Arrays;

class DP implements Solution {

    private static final int MOD = 1000000007;

    @Override
    public int countPalindromicSubsequences(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] last = new int[101];
        Arrays.fill(last, -1);
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = last[c[i]];
            last[c[i]] = i;
        }
        Arrays.fill(last, n);
        int[] p = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            p[i] = last[c[i]];
            last[c[i]] = i;
        }
        long[][] f = new long[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        for (int l = n - 2; l >= 0; l--) {
            for (int r = l + 1; r < n; r++) {
                if (c[l] != c[r]) {
                    f[l][r] = f[l + 1][r] + f[l][r - 1] - f[l + 1][r - 1] + MOD;
                } else {
                    int i = p[l], j = q[r];
                    if (i > j) {
                        f[l][r] = f[l + 1][r - 1] * 2 + 2;
                    } else if (i == j) {
                        f[l][r] = f[l + 1][r - 1] * 2 + 1;
                    } else {
                        f[l][r] = f[l + 1][r - 1] * 2 - f[i + 1][j - 1] + MOD;
                    }
                }
                f[l][r] %= MOD;
            }
        }
        return (int) f[0][n - 1];
    }

}
