package io.huhu.leetcode.dynamic.programming.hard.n329;

final class DFSSolution extends Solution {

    @Override
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mem[i][j] = -1;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(mem, matrix, i, m, j, n));
            }
        }
        return ans;
    }

    private int dfs(int[][] mem, int[][] matrix, int i, int m, int j, int n) {
        if (matrix[i][j] == -1) {
            return 0;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int num = matrix[i][j], ans = 1;
        matrix[i][j] = -1;
        if (i + 1 < m && matrix[i + 1][j] > num) {
            ans = Math.max(ans, 1 + dfs(mem, matrix, i + 1, m, j, n));
        }
        if (i - 1 >= 0 && matrix[i - 1][j] > num) {
            ans = Math.max(ans, 1 + dfs(mem, matrix, i - 1, m, j, n));
        }
        if (j + 1 < n && matrix[i][j + 1] > num) {
            ans = Math.max(ans, 1 + dfs(mem, matrix, i, m, j + 1, n));
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > num) {
            ans = Math.max(ans, 1 + dfs(mem, matrix, i, m, j - 1, n));
        }
        matrix[i][j] = num;
        return mem[i][j] = ans;
    }

}
