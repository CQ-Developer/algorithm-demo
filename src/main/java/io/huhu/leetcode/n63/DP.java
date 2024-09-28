package io.huhu.leetcode.n63;

class DP implements Code {

    @Override
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0 && obstacleGrid[i][n - 1] == 0; i--) {
            dp[i][n - 1] = 1;
        }
        for (int j = n - 1; j >= 0 && obstacleGrid[m - 1][j] == 0; j--) {
            dp[m - 1][j] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
