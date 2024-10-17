package io.huhu.leetcode.greedy.n1167;

import java.util.PriorityQueue;
import java.util.Queue;

class Greedy implements Code {

    @Override
    public int connectSticks(int[] sticks) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int stick : sticks) {
            heap.add(stick);
        }
        int ans = 0;
        while (heap.size() > 1) {
            int sum = heap.remove() + heap.remove();
            ans += sum;
            heap.offer(sum);
        }
        return ans;
    }

}
