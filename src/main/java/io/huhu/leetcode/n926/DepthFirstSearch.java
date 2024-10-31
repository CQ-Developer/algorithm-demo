package io.huhu.leetcode.n926;

import io.huhu.MLE;

import java.util.Arrays;

@MLE
class DepthFirstSearch implements Code {

    @Override
    public int minFlipsMonoIncr(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(c, 0, n - 1, dp);
    }

    /**
     * f(l,r)表示将l..r翻转成单调递增的最小代价
     */
    private int f(char[] s, int l, int r, int[][] dp) {
        if (l == r) {
            return 0;
        }
        if (l + 1 == r) {
            return s[l] <= s[r] ? 0 : 1;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (s[l] == s[r]) {
            dp[l][r] = Math.min(f(s, l + 1, r - 1, dp) + 1, s[l] == '0' ? f(s, l + 1, r, dp) : f(s, l, r - 1, dp));
        } else {
            dp[l][r] = s[l] == '0' ? f(s, l + 1, r - 1, dp) : Math.min(f(s, l + 1, r, dp) + 1, f(s, l, r - 1, dp) + 1);
        }
        return dp[l][r];
    }

}
