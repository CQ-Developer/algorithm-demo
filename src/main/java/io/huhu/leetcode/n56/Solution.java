package io.huhu.leetcode.n56;

/**
 * <h1>56.合并区间</h1>
 * <p>以数组intervals表示若干区间的集合，其中单个区间为intervals[i]=[start<sub>i</sub>, end<sub>i</sub>]。<br>
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。</p>
 * <p>示例1：<br>
 * 输入：intervals=[[1,3],[2,6],[8,10],[15,18]]<br>
 * 输出：[[1,6],[8,10],[15,18]]<br>
 * 解释：区间[1,3]和[2,6]重叠，将它们合并为[1,6]</p>
 * <p>示例2：<br>
 * 输入：intervals=[[1,4],[4,5]]<br>
 * 输出：[[1,5]]<br>
 * 解释：区间[1,4]和[4,5]可被视为重叠区间。</p>
 * <p>提示：<br>
 * 1 <= intervals.length <= 10<sup>4</sup><br>
 * intervals[i].length == 2<br>
 * 0 <= start<sub>i</sub> <= end<sub>i</sub> <= 10<sup>4</sup></p>
 */
class Solution {

    public int[][] merge(int[][] intervals) {
        int c = 0;
        boolean[] used = new boolean[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            if (!used[i]) {
                int[] current = {intervals[i][0], intervals[i][1]};
                used[i] = true;
                for (int j = i + 1; j < intervals.length; j++) {
                    if (!used[j]) {
                        int[] next = {intervals[j][0], intervals[j][1]};
                        if ((next[0] >= current[0] && next[0] <= current[1]) || (next[1] >= current[0] && next[1] <= current[1]) || (next[0] < current[0] && next[1] > current[1])) {
                            current[0] = current[0] < next[0] ? current[0] : next[0];
                            current[1] = current[1] > next[1] ? current[1] : next[1];
                            used[j] = true;
                        }
                    }
                }
                if (c == 0) {
                    intervals[c++] = current;
                }
                else {
                    int[] before = {intervals[c - 1][0], intervals[c - 1][1]};
                    if ((current[0] >= before[0] && current[0] <= before[1]) || (current[1] >= before[0] || current[1] <= before[1]) || (current[0] < before[0] && current[1] < before[1])) {
                        before[0] = before[0] < current[0] ? before[0] : current[0];
                        before[1] = before[1] > current[1] ? before[1] : current[1];
                    }
                    else {
                        intervals[c++] = current;
                    }
                }
            }
        }
        int[][] result = new int[c][];
        System.arraycopy(intervals, 0, result, 0, c);
        return result;
    }

}
