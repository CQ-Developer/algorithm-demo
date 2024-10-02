package io.huhu.leetcode.n221;

class DP implements Code {

    @Override
    public int maximalSquare(char[][] matrix) {
        int len = 0;
        int h = matrix.length, w = matrix[0].length;
        int[][] dp = new int[h + 1][w + 1];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    len = Math.max(len, dp[i + 1][j + 1]);
                }
            }
        }
        return len * len;
    }

}
