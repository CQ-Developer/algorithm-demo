package io.huhu.leetcode.n1049;

import java.util.Arrays;

class DepthFirstSearch implements Code {

    @Override
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int[][] dp = new int[stones.length][1 + (sum >> 1)];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int weight = f(stones, sum >> 1, dp, 0, 0);
        return sum - weight - weight;
    }

    private int f(int[] stones, int weight, int[][] dp, int i, int w) {
        if (i == stones.length) {
            return w;
        }
        if (dp[i][w] != -1) {
            return dp[i][w];
        }
        int ans = f(stones, weight, dp, i + 1, w);
        if (w + stones[i] <= weight) {
            ans = Math.max(ans, f(stones, weight, dp, i + 1, w + stones[i]));
        }
        return dp[i][w] = ans;
    }

}
