package io.huhu.leetcode.dynamic.programming.hard.n354;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/russian-doll-envelopes/description/">
 * Russian Doll Envelopes
 * </a>
 */
class Solution {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int k = 0;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < dp.length; i++) {
            int j = binarySearch(dp, k, envelopes[i][1]);
            if (j == -1) {
                dp[k++] = envelopes[i][1];
            } else {
                dp[j] = envelopes[i][1];
            }
        }
        return k;
    }

    private int binarySearch(int[] dp, int len, int num) {
        int l = 0, r = len - 1, ans = -1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (num <= dp[m]) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

}
