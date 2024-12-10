package io.huhu.leetcode.n2054;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Greedy implements Solution {

    @Override
    public int maxTwoEvents(int[][] events) {
        // 开始时间由小到大排列
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        // 结束时间由大到小排列
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int res = 0, max = 0;
        for (int[] event : events) {
            // 将堆顶元素结束时间小于当前开始时间的元素全部弹出并取得最大收益
            while (!heap.isEmpty() && heap.peek()[1] < event[0]) {
                max = Math.max(max, heap.poll()[2]);
            }
            res = Math.max(res, max + event[2]);
            heap.offer(event);
        }
        return res;
    }

}
