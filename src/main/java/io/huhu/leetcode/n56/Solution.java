package io.huhu.leetcode.n56;

import java.util.ArrayList;
import java.util.List;

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
        List<int[]> list = new ArrayList<>(intervals.length);
        boolean[] used = new boolean[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            if (!used[i]) {
                used[i] = true;
                int[] tmp = {intervals[i][0], intervals[i][1]};
                for (int j = i + 1; j < intervals.length; j++) {
                    if (!used[j] && intervals[j][0] >= intervals[i][0] && intervals[j][0] <= intervals[i][1]) {
                        tmp[1] = intervals[j][1];
                        used[j] = true;
                    }
                }
                list.add(tmp);
            }
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
