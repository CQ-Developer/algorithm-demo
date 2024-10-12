package io.huhu.leetcode.n435;

import java.util.Arrays;

class DP implements Code {

    @Override
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        // dp[i]表示必须包含i区间的情况下
        // 以i结尾的最长不重复区间长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int m = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            m = Math.max(m, dp[i]);
        }
        return n - m;
    }

}
