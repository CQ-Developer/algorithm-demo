package io.huhu.leetcode.n907;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class MonotoneStack implements Code {

    private static final int M = 1000000007;

    @Override
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n], right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(-1);
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && arr[stack.getFirst()] >= arr[i]) {
                right[stack.removeFirst()] = i;
            }
            left[i] = stack.getFirst();
            stack.addFirst(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * (i - left[i]) * (right[i] - i)) % M;
        }
        return (int) ans;
    }

}
