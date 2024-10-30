package io.huhu.leetcode.n907;

import java.util.ArrayDeque;
import java.util.Deque;

class MonotoneStack implements Code {

    private static final int M = 1000000007;

    @Override
    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(-1);
        for (int r = 0; r <= arr.length; r++) {
            int x = r < arr.length ? arr[r] : -1;
            while (stack.size() > 1 && arr[stack.getFirst()] >= x) {
                int i = stack.removeFirst();
                ans = (ans + (long) arr[i] * (i - stack.getFirst()) * (r - i)) % M;
            }
            stack.addFirst(r);
        }
        return (int) ans;
    }

}
