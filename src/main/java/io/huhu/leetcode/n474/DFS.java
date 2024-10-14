package io.huhu.leetcode.n474;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] ones = new int[len], zeroes = new int[len];
        for (int i = 0; i < len; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zeroes[i]++;
                } else {
                    ones[i]++;
                }
            }
        }
        int[][][] dp = new int[len][m + 1][n + 1];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return f(ones, zeroes, 0, m, n, dp);
    }

    private int f(int[] ones, int[] zeros, int i, int m, int n, int[][][] dp) {
        if (i == ones.length) {
            return 0;
        }
        if (dp[i][m][n] != -1) {
            return dp[i][m][n];
        }
        int ans = f(ones, zeros, i + 1, m, n, dp);
        if (m >= zeros[i] && n >= ones[i]) {
            ans = Math.max(ans, f(ones, zeros, i + 1, m - zeros[i], n - ones[i], dp) + 1);
        }
        return dp[i][m][n] = ans;
    }

}
