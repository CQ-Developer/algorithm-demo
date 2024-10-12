package io.huhu.leetcode.n435;

import java.util.Arrays;

class DP implements Code {

    @Override
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        // 无重复子区间的最右侧
        int[] dp = new int[n];
        int m = 1;
        dp[0] = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= dp[m - 1]) {
                dp[m++] = interval[1];
            } else {
                int j = bs(dp, m, interval);
                if (j > 0 && interval[0] >= dp[j - 1]) {
                    dp[j] = interval[1];
                }
            }
        }
        return n - m;
    }

    private int bs(int[] dp, int n, int[] interval) {
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (dp[m] < interval[1]) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

}
