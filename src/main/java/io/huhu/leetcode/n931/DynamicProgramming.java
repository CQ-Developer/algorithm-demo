package io.huhu.leetcode.n931;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE, n = matrix.length;
        int[][] f = new int[n + 1][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int _ans = f[i + 1][j];
                if (j - 1 >= 0) {
                    _ans = Math.min(_ans, f[i + 1][j - 1]);
                }
                if (j + 1 < n) {
                    _ans = Math.min(_ans, f[i + 1][j + 1]);
                }
                f[i][j] = _ans + matrix[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, f[0][j]);
        }
        return ans;
    }

}
