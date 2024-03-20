package io.huhu.leetcode.dynamic.programming.medium.n72;

/**
 * <a href="https://leetcode.cn/problems/edit-distance/description/">编辑距离</a>
 */
class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] chars1 = new char[m + 1], chars2 = new char[n + 1];
        System.arraycopy(word1.toCharArray(), 0, chars1, 1, m++);
        System.arraycopy(word2.toCharArray(), 0, chars2, 1, n++);
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (chars1[i] == chars2[j]) {
                    // 字符相同不需要动
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // dp[i - 1][j - 1] 表示替换操作
                    // dp[i - 1][j]     表示删除操作
                    // dp[i][j - 1]     表示插入操作
                    // 找到成本最小的操作 +1 即可
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
