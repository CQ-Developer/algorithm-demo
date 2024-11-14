package io.huhu.leetcode.n1162;

class DynamicProgramming implements Code {

    @Override
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    f[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (i - 1 >= 0) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                    }
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    if (i + 1 < m) {
                        f[i][j] = Math.min(f[i][j], f[i + 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
                    }
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && f[i][j] != Integer.MAX_VALUE - 1) {
                    ans = Math.max(ans, f[i][j]);
                }
            }
        }
        return ans;
    }

}
