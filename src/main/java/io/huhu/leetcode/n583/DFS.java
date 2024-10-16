package io.huhu.leetcode.n583;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int m = w1.length, n = w2.length;
        int[][] dp = new int[m][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(w1, w2, 0, 0, dp);
    }

    private int f(char[] w1, char[] w2, int i, int j, int[][] dp) {
        if (i == w1.length && j == w2.length) {
            return 0;
        }
        if (i == w1.length) {
            return w2.length - j;
        }
        if (j == w2.length) {
            return w1.length - i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (w1[i] == w2[j]) {
            return dp[i][j] = f(w1, w2, i + 1, j + 1, dp);
        }
        return dp[i][j] = Math.min(f(w1, w2, i + 1, j, dp), f(w1, w2, i, j + 1, dp)) + 1;
    }

}
