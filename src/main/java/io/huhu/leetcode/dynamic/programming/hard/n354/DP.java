package io.huhu.leetcode.dynamic.programming.hard.n354;

import java.util.Arrays;

/**
 * timeout!
 */
class DP implements Solution {

    @Override
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Integer.max(dp[i], dp[j]);
                }
            }
            ans = Integer.max(ans, ++dp[i]);
        }
        return ans;
    }

}
