package io.huhu.leetcode.dynamic.programming.hard.n1000;

class DepthFirstSearch implements Solution {

    @Override
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + stones[i];
        }
        return f(pre, k, 0, n - 1);
    }

    private int f(int[] pre, int k, int l, int r) {
        if (l == r) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = l; i < r; i += k - 1) {
            ans = Math.min(ans, f(pre, k, l, i) + f(pre, k, i + 1, r));
        }
        if ((r - l) % (k - 1) == 0) {
            ans += pre[r + 1] - pre[l];
        }
        return ans;
    }

}
