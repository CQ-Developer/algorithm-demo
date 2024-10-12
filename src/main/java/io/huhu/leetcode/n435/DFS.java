package io.huhu.leetcode.n435;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        return f(intervals, 0, 1);
    }

    private int f(int[][] intervals, int i, int j) {
        if (j == intervals.length) {
            return 0;
        }
        // 不重叠: 比较下一对区间
        if (intervals[i][1] <= intervals[j][0]) {
            return f(intervals, j, j + 1);
        }
        // 完全包含: 移除前一个区间
        if (intervals[i][1] >= intervals[j][1]) {
            return f(intervals, j, j + 1) + 1;
        }
        // 部分重叠: 移除后一个区间
        return f(intervals, i, j + 1) + 1;
    }

}
