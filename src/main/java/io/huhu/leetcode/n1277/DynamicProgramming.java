package io.huhu.leetcode.n1277;

class DynamicProgramming implements Code {

    @Override
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = Math.min(f[i - 1][j], Math.min(f[i][j - 1], f[i - 1][j - 1])) + 1;
                }
                ans += f[i][j];
            }
        }
        return ans;
    }

}
