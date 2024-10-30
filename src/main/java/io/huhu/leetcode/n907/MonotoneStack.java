package io.huhu.leetcode.n907;

import java.util.ArrayDeque;
import java.util.Deque;

class MonotoneStack implements Code {

    private static final int M = 1000000007;

    @Override
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(-1);
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && arr[stack.getFirst()] >= arr[i]) {
                stack.removeFirst();
            }
            left[i] = stack.getFirst();
            stack.addFirst(i);
        }
        int[] right = new int[n];
        stack.clear();
        stack.addFirst(n);
        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 1 && arr[stack.getFirst()] > arr[i]) {
                stack.removeFirst();
            }
            right[i] = stack.getFirst();
            stack.addFirst(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * (i - left[i]) * (right[i] - i)) % M;
        }
        return (int) ans;
    }

}
