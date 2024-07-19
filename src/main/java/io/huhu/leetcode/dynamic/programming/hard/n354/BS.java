package io.huhu.leetcode.dynamic.programming.hard.n354;

import java.util.Arrays;

class BS implements Solution {

    @Override
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int size = 0;
        int[] dp = new int[envelopes.length];
        for (int[] envelope : envelopes) {
            int num = envelope[1];
            int i = bs(dp, size, num);
            if (i == -1) {
                dp[size++] = num;
            } else {
                dp[i] = num;
            }
        }
        return size;
    }

    private int bs(int[] dp, int n, int num) {
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
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
