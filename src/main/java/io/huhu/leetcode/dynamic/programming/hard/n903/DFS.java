package io.huhu.leetcode.dynamic.programming.hard.n903;

import java.util.Arrays;

class DFS implements Solution {

    private static final int M = 1000000007;

    @Override
    public int numPermsDISequence(String s) {
        char[] c = s.toCharArray();
        int n = c.length + 1;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return dfs(c, 0, n, n, dp);
    }

    private int dfs(char[] s, int i, int less, int n, int[][] dp) {
        if (dp[i][less] != -1) {
            return dp[i][less];
        }
        int ans = 0;
        if (i == n) {
            return 1;
        } else if (i == 0 || s[i - 1] == 'D') {
            for (int j = 0; j < less; j++) {
                ans = (ans + dfs(s, i + 1, j, n, dp)) % M;
            }
        } else {
            for (int j = less; j < n - i; j++) {
                ans = (ans + dfs(s, i + 1, j, n, dp)) % M;
            }
        }
        return dp[i][less] = ans;
    }

}
