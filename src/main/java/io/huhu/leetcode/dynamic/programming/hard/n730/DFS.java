package io.huhu.leetcode.dynamic.programming.hard.n730;

import java.util.Arrays;

class DFS implements Solution {

    private static final int MOD = 1000000007;

    @Override
    public int countPalindromicSubsequences(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] last = new int[101];
        // i位置左侧最近的相同字符位置, 默认-1
        Arrays.fill(last, -1);
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = last[c[i]];
            last[c[i]] = i;
        }
        // i位置右侧最近相同字符位置, 默认n
        Arrays.fill(last, n);
        int[] p = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            p[i] = last[c[i]];
            last[c[i]] = i;
        }
        return (int) f(c, 0, n - 1, q, p);
    }

    private long f(char[] s, int l, int r, int[] q, int[] p) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return 1;
        }
        long ans;
        // 两端字符相同
        if (s[l] != s[r]) {
            ans = f(s, l + 1, r, q, p) + f(s, l, r - 1, q, p) - f(s, l + 1, r - 1, q, p) + MOD;
        }
        // 两端字符不同
        else {
            int i = p[l], j = q[r];
            // 不存在
            if (i > j) {
                ans = f(s, l + 1, r - 1, q, p) * 2 + 2;
            }
            // 存在1个
            else if (i == j) {
                ans = f(s, l + 1, r - 1, q, p) * 2 + 1;
            }
            // 存在n个
            else {
                ans = f(s, l + 1, r - 1, q, p) * 2 - f(s, i + 1, j - 1, q, p) + MOD;
            }
        }
        return ans % MOD;
    }

}
