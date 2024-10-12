package io.huhu.leetcode.n435;

import java.util.Arrays;

class Greedy implements Code {

    @Override
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int n = 0, r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= r) {
                r = intervals[i][1];
            } else {
                n++;
            }
        }
        return n;
    }

}
