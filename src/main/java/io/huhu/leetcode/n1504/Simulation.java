package io.huhu.leetcode.n1504;

import io.huhu.AC;

@AC
class Simulation implements Code {

    @Override
    public int numSubmat(int[][] mat) {
        int ans = 0, m = mat.length, n = mat[0].length;
        int[][] widths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // this acts like dynamic programming
                if (j == 0) {
                    widths[i][j] = mat[i][j];
                } else {
                    widths[i][j] = mat[i][j] == 0 ? 0 : widths[i][j - 1] + 1;
                }
                // find the narrowest till the top
                int width = n;
                for (int _i = i; _i >= 0 && width != 0; _i--) {
                    ans += width = Math.min(width, widths[_i][j]);
                }
            }
        }
        return ans;
    }

}
