package io.huhu.leetcode.dynamic.programming.hard.n1000;

import java.util.Arrays;

class MemorySearch implements Solution {

    @Override
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        int[][] m = new int[n][n];
        for (int[] a : m) {
            Arrays.fill(a, -1);
        }
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + stones[i];
        }
        return f(p, k, m, 0, n - 1);
    }

    private int f(int[] p, int k, int[][] m, int l, int r) {
        if (l == r) {
            return 0;
        }
        m[l][r] = Integer.MAX_VALUE;
        for (int i = l; i < r; i += k - 1) {
            m[l][r] = Math.min(m[l][r], f(p, k, m, l, i) + f(p, k, m, i + 1, r));
        }
        if ((r - l) % (k - 1) == 0) {
            m[l][r] += p[r + 1] - p[l];
        }
        return m[l][r];
    }

}
