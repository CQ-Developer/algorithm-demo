package io.huhu.leetcode.n473;

import java.util.Arrays;

class DP implements Code {

    @Override
    public boolean makesquare(int[] matchsticks) {
        int m = 0;
        for (int matchstick : matchsticks) {
            m += matchstick;
        }
        if (m % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        m >>= 2;
        int n = matchsticks.length;
        if (matchsticks[n - 1] > m) {
            return false;
        }
        // dp[s]表示正方形未放满的边的当前长度
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        // dp[0]表示状态为0, 即没有火柴被放入
        dp[0] = 0;
        for (int s = 1; s < dp.length; s++) {
            for (int i = n - 1; i >= 0; i--) {
                if (((1 << i) & s) != 0) {
                    int s1 = s ^ (1 << i);
                    if (dp[s1] >= 0 && dp[s1] + matchsticks[i] <= m) {
                        dp[s] = (dp[s1] + matchsticks[i]) % m;
                        break;
                    }
                }
            }
        }
        return dp[dp.length - 1] == 0;
    }

}
