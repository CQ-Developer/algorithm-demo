package io.huhu.leetcode.dynamic.programming.hard.n730;

import java.util.Arrays;

class DFS implements Solution {

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
        long[][] m = new long[n][n];
        for (var a : m) {
            Arrays.fill(a, -1);

        }
        return (int) f(c, 0, n - 1, q, p, m);
    }

    private long f(char[] s, int l, int r, int[] q, int[] p, long[][] m) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return 1;
        }
        if (m[l][r] != -1) {
            return m[l][r];
        }
        long ans;
        if (s[l] != s[r]) {
            ans = f(s, l + 1, r, q, p, m) + f(s, l, r - 1, q, p, m) - f(s, l + 1, r - 1, q, p, m) + MOD;
        } else {
            int i = p[l], j = q[r];
            if (i > j) {
                ans = f(s, l + 1, r - 1, q, p, m) * 2 + 2;
            } else if (i == j) {
                ans = f(s, l + 1, r - 1, q, p, m) * 2 + 1;
            } else {
                ans = f(s, l + 1, r - 1, q, p, m) * 2 - f(s, i + 1, j - 1, q, p, m) + MOD;
            }
        }
        return m[l][r] = ans % MOD;
    }

}
