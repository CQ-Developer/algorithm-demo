package io.huhu.leetcode.dynamic.programming.hard.n115;

/**
 * <a href="https://leetcode.cn/problems/distinct-subsequences/description/">
 * Distinct Subsequences
 * </a>
 */
class Solution {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= m; i++) {
            int leftUp = f[0];
            for (int j = 1; j <= n; j++) {
                int a = f[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    f[j] += leftUp;
                }
                leftUp = a;
            }
        }
        return f[n];
    }

}
