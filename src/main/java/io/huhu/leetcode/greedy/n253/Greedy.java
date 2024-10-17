package io.huhu.leetcode.greedy.n253;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Greedy implements Code {

    @Override
    public int minMeetingRooms(int[][] meeting) {
        // 以会议的开始时间排序
        Arrays.sort(meeting, (a, b) -> a[0] - b[0]);
        // 堆中保存会议的结束时间
        Queue<Integer> heap = new PriorityQueue<>();
        int ans = 0;
        for (int[] time : meeting) {
            /*
             * 堆顶保存的是之前会议的最早结束时间
             * 如果当前会议的开始时间大于等于之前会议的结束时间
             * 说明当前会议不会和之前的会议重合
             *
             * 之前有重合的会议的数量已统计过
             * 将所有不会重合的会议全部弹出
             * 重新开始计算新的重合会议
             */
            while (!heap.isEmpty() && heap.peek() <= time[0]) {
                heap.poll();
            }
            // 新的会议和之前的会议重合入堆
            heap.offer(time[1]);
            // 计算最大重合
            if (heap.size() > ans) {
                ans = heap.size();
            }
        }
        return ans;
    }

}
