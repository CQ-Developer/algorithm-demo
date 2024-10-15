package io.huhu.leetcode.n526;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int countArrangement(int n) {
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        return f(0, n, dp);
    }

    private int f(int s, int n, int[] dp) {
        if ((1 << n) - 1 == s) {
            return 1;
        }
        if (dp[s] != -1) {
            return dp[s];
        }
        int ans = 0;
        // bitCounts理解为数组的长度, +1表示下标从1开始
        int i = Integer.bitCount(s) + 1;
        for (int j = 1; j <= n; j++) {
            int mask = 1 << (j - 1);
            if ((mask & s) == 0 && (j % i == 0 || i % j == 0)) {
                ans += f(mask | s, n, dp);
            }
        }
        return dp[s] = ans;
    }

}
