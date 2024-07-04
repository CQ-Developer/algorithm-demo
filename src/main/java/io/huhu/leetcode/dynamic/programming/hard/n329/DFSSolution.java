package io.huhu.leetcode.dynamic.programming.hard.n329;

final class DFSSolution extends Solution {

    @Override
    public int longestIncreasingPath(int[][] matrix) {
        int[][] mem = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans = Math.max(ans, dfs(mem, matrix, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] mem, int[][] matrix, int i, int j) {
        if (matrix[i][j] == -1) {
            return 0;
        }
        if (mem[i][j] != 0) {
            return mem[i][j];
        }
        int ans = 0;
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            ans = Math.max(ans, dfs(mem, matrix, i + 1, j));
        }
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            ans = Math.max(ans, dfs(mem, matrix, i - 1, j));
        }
        if (j + 1 < matrix[i].length && matrix[i][j + 1] > matrix[i][j]) {
            ans = Math.max(ans, dfs(mem, matrix, i, j + 1));
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            ans = Math.max(ans, dfs(mem, matrix, i, j - 1));
        }
        return mem[i][j] = ans + 1;
    }

}
