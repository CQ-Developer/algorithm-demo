package io.huhu.leetcode.n57;

/**
 * <h1>57.插入区间</h1>
 * <p>给你一个无重叠的，按照区间起始端点排序的区间列表。<br>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠(如果右必要的话，可以合并区间)。</p>
 * <p>示例1：<br>
 * 输入：intervals=[[1,3],[6,9]], newInterval=[2,5]<br>
 * 输出：[[1,5],[6,9]]</p>
 * <p>示例2：<br>
 * 输入：intervals=[[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval=[4,8]<br>
 * 输出：[[1,2],[3,10],[12,16]]<br>
 * 解释：这是因为新的区间[4,8]与[3,5],[6,7],[8,10]重叠</p>
 * <p>示例3：<br>
 * 输入：intervals=[], newInterval=[5,7]<br>
 * 输出：[[5,7]]</p>
 * <p>示例4：<br>
 * 输入：intervals=[[1,5]], newInterval=[2,3]<br>
 * 输出：[[1,5]]</p>
 * <p>示例5：<br>
 * 输入：intervals=[[1,5]], newInterval=[2,7]<br>
 * 输出: [[1,7]]</p>
 * <p>提示：<br>
 * 0 <= intervals.length <= 10<sup>4</sup><br>
 * intervals[i].length == 2<br>
 * 0 <= intervals[i][0] <= intervals[i][1] <= 10<sup>5</sup><br>
 * intervals根据intervals[i][0]按升序排列<br>
 * newInterval.length == 2<br>
 * 0 <= newInterval[0] <= newInterval[1] <= 10<sup>5</sup></p>
 */
class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        // 排序
        // 找到newInterval应该在intervals中的位置
        int idx = 0;
        for (; idx < intervals.length; idx++) {
            if (newInterval[0] < intervals[idx][0]) {
                break;
            }
        }
        // 将newInterval插入到intervals中
        int[][] arr = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, arr, 0, idx);
        arr[idx] = newInterval;
        System.arraycopy(intervals, idx, arr, idx + 1, arr.length - idx - 1);
        // 合并区间
        // 合并过程和第56题完全一致
        int len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] > arr[len - 1][1]) {
                arr[len++] = arr[i];
            } else {
                arr[len - 1][1] = Math.max(arr[len - 1][1], arr[i][1]);
            }
        }
        // 获得合并后的区间
        int[][] result = new int[len][];
        System.arraycopy(arr, 0, result, 0, len);
        return result;
    }

}
