package io.huhu.leetcode.n1035;

import java.util.Arrays;

public class DepthFirstSearch implements Code {

    @Override
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(nums1, nums2, dp, m - 1, n - 1);
    }

    private int f(int[] a, int[] b, int[][] dp, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (a[i] == b[j]) {
            dp[i][j] = f(a, b, dp, i - 1, j - 1) + 1;
        } else {
            dp[i][j] = Math.max(f(a, b, dp, i - 1, j), f(a, b, dp, i, j - 1));
        }
        return dp[i][j];
    }

}
