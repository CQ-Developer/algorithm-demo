package io.huhu.leetcode.dynamic.programming.medium.n279;

/**
 * <a href="https://leetcode.cn/problems/perfect-squares/description/">完全平方数</a>
 */
class Solution {

    public int numSquares(int n) {
        return dfs(n, new int[n + 1]);
    }

    private int dfs(int n, int[] cache) {
        if (n <= 3) {
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = n >> 1; i > 0; i--) {
            int s = i * i;
            if (s <= n) {
                ans = Math.min(ans, 1 + dfs(n - s, cache));
            }
        }
        return cache[n] = ans;
    }

}
