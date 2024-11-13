package io.huhu.leetcode.n1140;

class DepthFirstSearch implements Code {

    @Override
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        for (int i = n - 2; i >= 0; i--) {
            // 后缀和
            piles[i] += piles[i + 1];
        }
        /*
         * 缓存的边界问题:
         * 如果每轮都选择2m堆石子且加上一轮的选择2m
         * 2 + 4 + 8 + ... + m + 2m < n
         * 根据等比数列求和公式得到:
         * 4m - 2 < n
         * 即: m <= (n + 1) / 4
         */
        return f(piles, new int[n][(n + 1) / 4 + 1], 0, 1);
    }

    /**
     * 当前玩家从第i堆石头开始最多能拿到的多少石子
     */
    private int f(int[] piles, int[][] dp, int i, int m) {
        if (i + 2 * m >= piles.length) {
            // 剩余石子堆可以一次性全部拿完
            return piles[i];
        }
        if (dp[i][m] != 0) {
            return dp[i][m];
        }
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; x++) {
            // 期望对方拿到的石子尽可能的少
            min = Math.min(min, f(piles, dp, i + x, Math.max(x, m)));
        }
        return dp[i][m] = piles[i] - min;
    }

}
