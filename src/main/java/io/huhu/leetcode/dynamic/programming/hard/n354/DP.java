package io.huhu.leetcode.dynamic.programming.hard.n354;

import java.util.Arrays;
import java.util.Comparator;

class DP implements Solution {

    @Override
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.<int[]>comparingInt(a -> a[0]).thenComparing(Comparator.<int[]>comparingInt(a -> a[1]).reversed()));
        int ans = 0;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
            ans = Integer.max(ans, dp[i]);
        }
        return ans;
    }

}
