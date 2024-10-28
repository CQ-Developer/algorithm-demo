package io.huhu.leetcode.n877;

class DynamicProgrammingA implements Code {

    @Override
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }
        int n = piles.length;
        int[][] f = new int[n][n];
        for (int l = n - 2; l >= 0; l--) {
            f[l][l + 1] = Math.max(piles[l], piles[l + 1]);
            for (int r = l + 2; r < n; r++) {
                f[l][r] = Math.max(f[l + 2][r] + piles[l], f[l][r - 2] + piles[r]);
            }
        }
        return f[0][n - 1] > sum / 2;
    }

}
