package io.huhu.leetcode.n1140;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Code {

    @Override
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        for (int i = n - 2; i >= 0; i--) {
            // 后缀和
            piles[i] += piles[i + 1];
        }
        return f(piles, 0, 1);
    }

    /**
     * 当前玩家从第i堆石头开始最多能拿到的多少石子
     */
    private int f(int[] piles, int i, int m) {
        if (i + 2 * m >= piles.length) {
            // 剩余石子堆可以一次性全部拿完
            return piles[i];
        }
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; x++) {
            // 期望对方拿到的石子尽可能的少
            min = Math.min(min, f(piles, i + x, Math.max(x, m)));
        }
        return piles[i] - min;
    }

}
