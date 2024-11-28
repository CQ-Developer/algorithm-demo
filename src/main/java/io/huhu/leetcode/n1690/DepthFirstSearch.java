package io.huhu.leetcode.n1690;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Code {

    @Override
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] left = new int[n + 1];
        for (int i = 0; i < n; i++) {
            left[i + 1] = left[i] + stones[i];
        }
        return f(left, 0, n - 1);
    }

    private int f(int[] left, int l, int r) {
        if (l >= r) {
            // if there is only one left, remove it and get 0 score.
            return 0;
        }
        return Math.max(left[r + 1] - left[l + 1] - f(left, l + 1, r), left[r] - left[l] - f(left, l, r - 1));
    }

}
