package io.huhu.leetcode.n1277;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] f = new int[n];
        for (int j = 0; j < n; j++) {
            ans += f[j] = matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            int lu = f[0];
            ans += f[0] = matrix[i][0];
            for (int j = 1; j < n; j++) {
                int _lu = f[j];
                if (matrix[i][j] == 0) {
                    f[j] = 0;
                } else {
                    f[j] = Math.min(f[j], Math.min(f[j - 1], lu)) + 1;
                }
                lu = _lu;
                ans += f[j];
            }
        }
        return ans;
    }

}
