package io.huhu.leetcode.n1696;

import io.huhu.AC;

import java.util.ArrayDeque;
import java.util.Deque;

@AC
class DynamicProgrammingDequeue implements Code {

    @Override
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        for (int i = 1; i < n; i++) {
            while (deque.getFirst() < i - k) {
                deque.removeFirst();
            }
            f[i] = f[deque.getFirst()] + nums[i];
            while (!deque.isEmpty() && f[deque.getLast()] <= f[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        return f[n - 1];
    }

}
