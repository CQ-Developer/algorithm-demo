package io.huhu.leetcode.n877;

class DepthFirstSearchA implements Code {

    @Override
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }
        int n = piles.length;
        int[][] dp = new int[n][n];
        int alice = f(piles, 0, n - 1, dp);
        return alice > sum - alice;
    }

    /**
     * 求 Alice 能得到的最多石子数
     */
    private int f(int[] piles, int l, int r, int[][] dp) {
        if (l + 1 == r) {
            return Math.max(piles[l], piles[r]);
        }
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        int a = f(piles, l + 2, r, dp) + piles[l];
        int b = f(piles, l, r - 2, dp) + piles[r];
        return dp[l][r] = Math.max(a, b);
    }

}
