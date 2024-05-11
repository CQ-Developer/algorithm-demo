package io.huhu.leetcode.dynamic.programming.medium.n97;

/**
 * <a href="https://leetcode.cn/problems/interleaving-string/description/">交错字符串</a>
 */
class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        return n + m == t && dfs(0, 0, 0, n, m, t, s1, s2, s3, new boolean[n + 1][m + 1]);
    }

    private boolean dfs(int i, int j, int k, int n, int m, int t, String s1, String s2, String s3, boolean[][] visited) {
        // s3字符串已经被遍历完成
        if (k == t) {
            return true;
        }
        // ij这条路曾经访问过，但没有成功，则不用再次访问
        if (visited[i][j]) {
            return false;
        }
        // 标记ij这条路被访问了
        visited[i][j] = true;
        // 判断s1[i]是否能交错
        // 1. i没有越界
        // 2. s1[i] == s3[k]
        // 3. 判断下一个字符，即 i+1 和 k+1
        if (i < n && s1.charAt(i) == s3.charAt(k) && dfs(i + 1, j, k + 1, n, m, t, s1, s2, s3, visited)) {
            return true;
        }
        // 判断s2[j]是否能交错
        // 1. j没有越界
        // 2. s2[j] == s3[k]
        // 3. 判断下一个字符，即 j+1 和 k+1
        if (j < m && s2.charAt(j) == s3.charAt(k) && dfs(i, j + 1, k + 1, n, m, t, s1, s2, s3, visited)) {
            return true;
        }
        // 都不能进行交错返回错误
        return false;
    }

}
