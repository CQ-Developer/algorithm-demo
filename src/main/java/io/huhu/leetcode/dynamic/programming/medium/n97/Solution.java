package io.huhu.leetcode.dynamic.programming.medium.n97;

/**
 * <a href="https://leetcode.cn/problems/interleaving-string/description/">交错字符串</a>
 */
class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        return dfs(0, 0, 0, n, m, t, s1, s2, s3, new boolean[n + 1][m + 1]);
    }

    private boolean dfs(int i, int j, int k, int n, int m, int t, String s1, String s2, String s3, boolean[][] cache) {
        if (k == t) {
            return true;
        }
        if (cache[i][j]) {
            return false;
        }
        cache[i][j] = true;
        if (i < n && s1.charAt(i) == s3.charAt(k) && dfs(i + 1, j, k + 1, n, m, t, s1, s2, s3, cache)) {
            return true;
        }
        if (j < m && s2.charAt(j) == s3.charAt(k) && dfs(i, j + 1, k + 1, n, m, t, s1, s2, s3, cache)) {
            return true;
        }
        return false;
    }

}
