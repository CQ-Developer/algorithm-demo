package io.huhu.leetcode.n764;

import java.util.Arrays;

class DP implements Code {

    @Override
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        boolean[][] g = new boolean[n][n];
        for (int[] mine : mines) {
            g[mine[0]][mine[1]] = true;
        }
        int[][] f = new int[n][n];
        for (int[] a : f) {
            Arrays.fill(a, n);
        }
        for (int i = 0; i < n; i++) {
            // left -> right
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (g[i][j]) {
                    count = 0;
                } else {
                    count++;
                }
                f[i][j] = Math.min(f[i][j], count);
            }
            // right -> left
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (g[i][j]) {
                    count = 0;
                } else {
                    count++;
                }
                f[i][j] = Math.min(f[i][j], count);
            }
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            // up -> down
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (g[i][j]) {
                    count = 0;
                } else {
                    count++;
                }
                f[i][j] = Math.min(f[i][j], count);
            }
            // down -> up
            count = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (g[i][j]) {
                    count = 0;
                } else {
                    count++;
                }
                f[i][j] = Math.min(f[i][j], count);
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans;
    }

}
