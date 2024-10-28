package io.huhu.leetcode.n877;

class DepthFirstSearchB implements Code {

    @Override
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        return f(piles, 0, n - 1, new int[n][n]) > 0;
    }

    /**
     * 假设初始为0，Alice选择则加上相应的数两，Bob选择则减去相应的数量，
     * 如果结果为正则Alice获胜，否则Bob获胜
     */
    private int f(int[] piles, int l, int r, int[][] dp) {
        if (l == r) {
            return piles[l];
        }
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        int a = piles[l] - f(piles, l + 1, r, dp);
        int b = piles[r] - f(piles, l, r - 1, dp);
        return dp[l][r] = Math.max(a, b);
    }

}
