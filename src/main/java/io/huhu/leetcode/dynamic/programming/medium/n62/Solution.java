package io.huhu.leetcode.dynamic.programming.medium.n62;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/unique-paths/description/">不同路径</a>
 */
class Solution {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[j]相当于到达[i-1,j]的走法
                // dp[j-1]相当于到达[i,j-1]的走法
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
