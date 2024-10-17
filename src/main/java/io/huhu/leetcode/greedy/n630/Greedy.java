package io.huhu.leetcode.greedy.n630;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Greedy implements Code {

    @Override
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            if (course[0] + time <= course[1]) {
                heap.offer(course[0]);
                time += course[0];
            } else {
                if (!heap.isEmpty() && heap.peek() > course[0]) {
                    time += course[0] - heap.poll();
                    heap.offer(course[0]);
                }
            }
        }
        return heap.size();
    }

}
