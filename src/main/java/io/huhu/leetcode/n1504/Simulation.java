package io.huhu.leetcode.n1504;

import io.huhu.AC;

@AC
class Simulation implements Code {

    @Override
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] widths = new int[m][n];
        for (int i = 0; i < m; i++) {
            widths[i][0] = mat[i][0];
            for (int j = 1; j < n; j++) {
                widths[i][j] = mat[i][j] == 0 ? 0 : widths[i][j - 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int width = widths[i][j];
                for (int k = i; k >= 0 && width != 0; k--) {
                    ans += width = Math.min(width, widths[k][j]);
                }
            }
        }
        return ans;
    }

}
