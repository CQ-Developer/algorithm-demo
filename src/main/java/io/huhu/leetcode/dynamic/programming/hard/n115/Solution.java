package io.huhu.leetcode.dynamic.programming.hard.n115;

/**
 * <a href="https://leetcode.cn/problems/distinct-subsequences/description/">
 * Distinct Subsequences
 * </a>
 */
class Solution {

    public int numDistinct(String s, String t) {
        char[] a = s.toCharArray(), b = t.toCharArray();
        int m = a.length, n = b.length;
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= m; i++) {
            int leftup = f[0];
            for (int j = 1; j <= n; j++) {
                int x = f[j];
                if (a[i - 1] == b[j - 1]) {
                    f[j] += leftup;
                }
                leftup = x;
            }
        }
        return f[n];
    }

}
