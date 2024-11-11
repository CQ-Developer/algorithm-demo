package io.huhu.leetcode.n1049;

class DynamicProgramming implements Code {

    @Override
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int n = stones.length, m = sum >> 1;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j - stones[i - 1] >= 0) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return sum - f[n][m] - f[n][m];
    }

}
