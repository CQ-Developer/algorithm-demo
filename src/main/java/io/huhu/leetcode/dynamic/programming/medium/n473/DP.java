package io.huhu.leetcode.dynamic.programming.medium.n473;

import java.util.Arrays;

class DP implements Solution {

    @Override
    public boolean makesquare(int[] matchsticks) {
        int target = sum(matchsticks);
        if (target % 4 != 0) {
            return false;
        }
        target >>= 2;
        Arrays.sort(matchsticks);
        int n = matchsticks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int status = 1; status < dp.length; status++) {
            for (int i = n - 1; i >= 0; i--) {
                if ((status & (1 << i)) != 0) {
                    int j = status & ~(1 << i);
                    if (dp[j] >= 0 && dp[j] + matchsticks[i] <= target) {
                        dp[status] = (dp[j] + matchsticks[i]) % target;
                        break;
                    }
                }
            }
        }
        return dp[dp.length - 1] == 0;
    }

    private int sum(int[] matchsticks) {
        int ans = 0;
        for (int matchstick : matchsticks) {
            ans += matchstick;
        }
        return ans;
    }

}
