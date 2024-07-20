package io.huhu.leetcode.dynamic.programming.medium.n646;

import java.util.Arrays;

class DP implements Solution {

    @Override
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int l = 0;
        int[] dp = new int[pairs.length];
        for (int[] pair : pairs) {
            int i = bs(dp, l, pair[0]);
            if (i == -1) {
                dp[l++] = pair[1];
            } else {
                dp[i] = Integer.min(dp[i], pair[1]);
            }
        }
        return l;
    }

    private int bs(int[] f, int n, int num) {
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (f[m] >= num) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

}
