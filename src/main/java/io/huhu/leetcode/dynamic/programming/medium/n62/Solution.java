package io.huhu.leetcode.dynamic.programming.medium.n62;

/**
 * <a href="https://leetcode.cn/problems/unique-paths/description/">不同路径</a>
 */
class Solution {

    public int uniquePaths(int m, int n) {
        // dp[i,j]表示走到该格子的所有走法之和
        int[][] dp = new int[m][n];
        // 第一行的每一格只有1种走法
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 第一列的每一格只有1种走法
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 题目规定只能向下或向右走
        // 所以当前位置[i,j]只能由[i-1,j]或[i,j-1]到达
        // 即到达当前位置[i,j]的走法 = 到达[i-1,j]的走法 + 到达[i,j-1]的走法
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
