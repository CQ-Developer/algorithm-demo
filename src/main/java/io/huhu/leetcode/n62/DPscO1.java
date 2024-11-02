package io.huhu.leetcode.n62;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DPscO1 implements Code {

    @Override
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
