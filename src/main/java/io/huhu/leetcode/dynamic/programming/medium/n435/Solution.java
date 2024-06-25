package io.huhu.leetcode.dynamic.programming.medium.n435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/non-overlapping-intervals/description/">Non-overlapping Intervals</a>
 * </h1>
 * <p>
 * Given an array of intervals where intervals[i] = [start<sub>i</sub>, end<sub>i</sub>],
 * return the minimum number of intervals you need to remove to make the rest of the
 * intervals non-overlapping.
 * </p>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= intervals.length <= 10<sup>5</sup></li>
     * <li>intervals[i].length == 2</li>
     * <li>-5 * 10<sup>4</sup> <= start<sub>i</sub> < end<sub>i</sub> <= 5 * 10<sup>4</sup></li>
     * </ul>
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int end = intervals[0][1], count = 0;
        for (int i = 1; i < intervals.length; i++) {
            // there is overlapping
            if (intervals[i][0] < end) {
                // keep the small range
                end = Math.min(end, intervals[i][1]);
                // delete the large range
                count++;
            }
            // there is non-overlapping
            else {
                end = intervals[i][1];
            }
        }
        return count;
    }

}
