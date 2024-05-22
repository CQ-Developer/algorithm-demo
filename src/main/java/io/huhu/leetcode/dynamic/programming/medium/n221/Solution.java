package io.huhu.leetcode.dynamic.programming.medium.n221;

/**
 * <a href="https://leetcode.cn/problems/maximal-square/description/">最大正方形</a>
 */
class Solution {

    public int maximalSquare(char[][] matrix) {
        int h = matrix.length, w = matrix[0].length, max = 0;
        int[][] dp = new int[h + 1][w + 1];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '1') {
                    // dp[i][j]就是以matrix[i-1][j-1]为右下角的正方形的最大边长
                    // 等同于dp[i+1][j+1]是以matrix[i][j]为右下角的正方形的最大边长
                    // 根据木桶效应，能构成正方形的最大边长即左、上、左上中最短的边
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                    // max用于记录最长边
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max * max;
    }

}
