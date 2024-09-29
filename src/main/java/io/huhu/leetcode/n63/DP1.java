package io.huhu.leetcode.n63;

class DP1 implements Code {

    @Override
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for (int j = n - 1; j >= 0 && obstacleGrid[m - 1][j] == 0; j--) {
            dp[j] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) {
                dp[n - 1] = 0;
            }
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    dp[j] += dp[j + 1];
                } else {
                    dp[j] = 0;
                }
            }
        }
        return dp[0];
    }

}
