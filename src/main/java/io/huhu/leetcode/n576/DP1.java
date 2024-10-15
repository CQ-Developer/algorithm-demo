package io.huhu.leetcode.n576;

class DP1 implements Code {

    private static final int M = 1000000007;

    private static final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * dp[k][i][j]表示经历k步到达i,j位置的路径数
     */
    @Override
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int ans = 0;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        for (int k = 0; k < maxMove; k++) {
            int[][] _dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int step = dp[i][j];
                    if (step > 0) {
                        for (int[] dir : DIR) {
                            int _i = i + dir[0], _j = j + dir[1];
                            if (_i >= 0 && _i < m && _j >= 0 && _j < n) {
                                _dp[_i][_j] = (_dp[_i][_j] + step) % M;
                            } else {
                                ans = (ans + step) % M;
                            }
                        }
                    }
                }
            }
            dp = _dp;
        }
        return ans;
    }

}
