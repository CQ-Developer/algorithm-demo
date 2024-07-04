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
            for (int j = n; j >= 1; j--) {
                if (a[i - 1] == b[j - 1]) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[n];
    }

}
