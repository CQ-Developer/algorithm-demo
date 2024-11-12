package io.huhu.leetcode.n1139;

class DynamicProgramming implements Code {

    @Override
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] bottom = new int[m + 1][n + 1], left = new int[m + 1][n + 1];
        int border = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    bottom[i][j] = bottom[i][j - 1] + 1;
                    left[i][j] = left[i - 1][j] + 1;
                    int _border = Math.min(bottom[i][j], left[i][j]);
                    while (_border > border) {
                        if (bottom[i - _border + 1][j] >= _border && left[i][j - _border + 1] >= _border) {
                            border = _border;
                            break;
                        }
                        _border--;
                    }
                }
            }
        }
        return border * border;
    }

}
