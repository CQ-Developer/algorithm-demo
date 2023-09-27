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
        sort(intervals);
        int j = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[j - 1][1]) {
                intervals[j++] = intervals[i];
            } else {
                intervals[j - 1][1] = intervals[j - 1][1] > intervals[i][1] ? intervals[j - 1][1] : intervals[i][1];
            }
        }
        int[][] result = new int[j][];
        System.arraycopy(intervals, 0, result, 0, j);
        return result;
    }

    /* 以下代码为快速排序，可以使用Arrays.sort()代替  */

    private void sort(int[][] intervals) {
        if (intervals.length > 1) {
            sort(intervals, 0, intervals.length - 1);
        }
    }

    private void sort(int[][] intervals, int start, int end) {
        if (start < end) {
            int left = start;
            int[] pivot = intervals[start];
            int right = end;
            while (left < right) {
                while (left < right && intervals[right][0] >= pivot[0]) {
                    right--;
                }
                while (left < right && intervals[left][0] <= pivot[0]) {
                    left++;
                }
                swap(intervals, left, right);
            }
            swap(intervals, start, right);
            sort(intervals, start, right - 1);
            sort(intervals, left + 1, end);
        }
    }

    private void swap(int[][] intervals, int left, int right) {
        if (left != right) {
            int[] tmp = intervals[left];
            intervals[left] = intervals[right];
            intervals[right] = tmp;
        }
    }

}
