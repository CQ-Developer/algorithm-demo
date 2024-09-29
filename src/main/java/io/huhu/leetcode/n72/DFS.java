package io.huhu.leetcode.n72;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int m = w1.length, n = w2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (var a : dp) {
            Arrays.fill(a, -1);
        }
        return f(w1, w2, m, n, dp);
    }

    private int f(char[] w1, char[] w2, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        if (i - 1 >= 0 && j - 1 >= 0) {
            if (w1[i - 1] == w2[j - 1]) {
                ans = f(w1, w2, i - 1, j - 1, dp);
            } else {
                ans = Math.min(ans, f(w1, w2, i - 1, j - 1, dp) + 1);
            }
        }
        if (i - 1 >= 0) {
            ans = Math.min(ans, f(w1, w2, i - 1, j, dp) + 1);
        }
        if (j - 1 >= 0) {
            ans = Math.min(ans, f(w1, w2, i, j - 1, dp) + 1);
        }
        return dp[i][j] = ans;
    }

}
