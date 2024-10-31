package io.huhu.leetcode.n931;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Code {

    @Override
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            ans = Math.min(ans, f(matrix, 0, j));
        }
        return ans;
    }

    private int f(int[][] matrix, int i, int j) {
        if (i == matrix.length) {
            return 0;
        }
        int ans = f(matrix, i + 1, j);
        if (j - 1 >= 0) {
            ans = Math.min(ans, f(matrix, i + 1, j - 1));
        }
        if (j + 1 < matrix[i].length) {
            ans = Math.min(ans, f(matrix, i + 1, j + 1));
        }
        return ans + matrix[i][j];
    }

}
