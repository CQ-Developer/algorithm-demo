package io.huhu.leetcode.n1139;

class DynamicProgramming implements Code {

    @Override
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 计算水平方向和垂直方向连续1的数量
        int[][] bottom = new int[m + 1][n + 1], left = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    bottom[i][j] = bottom[i][j - 1] + 1;
                    left[i][j] = left[i - 1][j] + 1;
                }
            }
        }
        // 动态规划
        // dp[i][j]表示以i,j为右下角的正方形
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 以底边和右边确认正方形的边
                int border = Math.min(bottom[i][j], left[i][j]);
                if (border > ans) {
                    while (border > ans) {
                        // 只有在上面和左边大于当前边的情况下才能构成正方形
                        if (bottom[i - border + 1][j] >= border && left[i][j - border + 1] >= border) {
                            ans = border;
                            break;
                        }
                        border--;
                    }
                }
            }
        }
        return ans * ans;
    }

}
