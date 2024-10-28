package io.huhu.leetcode.n877;

class DynamicProgrammingB implements Code {

    @Override
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            f[i] = piles[i];
            for (int j = i + 1; j < n; j++) {
                f[j] = Math.max(piles[i] - f[j], piles[j] - f[j - 1]);
            }
        }
        return f[n - 1] > 0;
    }

}
