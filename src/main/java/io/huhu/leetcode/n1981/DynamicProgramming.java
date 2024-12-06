package io.huhu.leetcode.n1981;

import io.huhu.AC;

@AC
class DynamicProgramming implements Solution {

    @Override
    public int minimizeTheDifference(int[][] mat, int target) {
        /*
         * 分组背包问题
         * f[i][j]表示能否从前i组物品中选出恰好为j的重量, 且每组只能选择1个物品
         */
        int n = mat.length, m = 4900;
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int num : mat[i]) {
                    if (j >= num) {
                        f[i + 1][j] |= f[i][j - num];
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j <= m; j++) {
            if (f[n][j]) {
                res = Math.min(res, Math.abs(j - target));
            }
        }
        return res;
    }

}
