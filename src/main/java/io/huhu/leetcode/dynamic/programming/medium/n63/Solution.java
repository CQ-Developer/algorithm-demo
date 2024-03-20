package io.huhu.leetcode.dynamic.programming.medium.n63;

/**
 * <a href="https://leetcode.cn/problems/unique-paths-ii/description/">不同路径II</a>
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        // 终点存在障碍不可达
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        // 第一行故障后的格子不可达
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            // 负数相加取反结果不变
            obstacleGrid[i][0] = -1;
        }
        // 第一列故障下的格子不可达
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            // 负数相加取反结果不变
            obstacleGrid[0][j] = -1;
        }
        // 动态规划
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    int a = obstacleGrid[i - 1][j] == 1 ? 0 : obstacleGrid[i - 1][j];
                    int b = obstacleGrid[i][j - 1] == 1 ? 0 : obstacleGrid[i][j - 1];
                    obstacleGrid[i][j] = a + b;
                }
            }
        }
        // 取反结果不变
        return -obstacleGrid[m - 1][n - 1];
    }

}
