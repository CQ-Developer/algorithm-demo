package io.huhu.leetcode.dynamic.programming.hard.n1000;

class DepthFirstSearch implements Solution {

    @Override
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + stones[i];
        }
        return f(p, k, 0, n - 1);
    }

    private int f(int[] p, int k, int l, int r) {
        if (l == r) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = l; i < r; i += k - 1) {
            ans = Math.min(ans, f(p, k, l, i) + f(p, k, i + 1, r));
        }
        if ((r - l) % (k - 1) == 0) {
            ans += p[r + 1] - p[l];
        }
        return ans;
    }

}
