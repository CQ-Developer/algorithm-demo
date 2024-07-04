package io.huhu.leetcode.dynamic.programming.hard.n115;

/**
 * <a href="https://leetcode.cn/problems/distinct-subsequences/description/">
 * Distinct Subsequences
 * </a>
 */
class Solution {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = f[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    f[i][j] += f[i - 1][j - 1];
                }
            }
        }
        return f[m][n];
    }

}
