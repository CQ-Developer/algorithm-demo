package io.huhu.leetcode.n712;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int m = c1.length, n = c2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(c1, c2, 0, 0, dp);
    }

    private int f(char[] c1, char[] c2, int i, int j, int[][] dp) {
        if (i == c1.length && j == c2.length) {
            return 0;
        }
        // c1 is matched and delete rest of s2
        if (i == c1.length) {
            int ans = 0;
            while (j < c2.length) {
                ans += c2[j++];
            }
            return ans;
        }
        // c2 is matched and delete rest of s1
        if (j == c2.length) {
            int ans = 0;
            while (i < c1.length) {
                ans += c1[i++];
            }
            return ans;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans;
        if (c1[i] == c2[j]) {
            ans = f(c1, c2, i + 1, j + 1, dp);
        } else {
            int a = f(c1, c2, i + 1, j, dp) + c1[i];
            int b = f(c1, c2, i, j + 1, dp) + c2[j];
            ans = Math.min(a, b);
        }
        return dp[i][j] = ans;
    }

}
