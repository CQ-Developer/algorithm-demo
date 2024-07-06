package io.huhu.leetcode.dynamic.programming.hard.n879;

final class DP implements Solution {

    @Override
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] f = new int[n + 1][minProfit + 1];
        for (int i = 0; i < f.length; i++) {
            f[i][0] = 1;
        }
        for (int i = group.length - 1; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    int a = f[j][k];
                    int b = group[i] <= j ? f[j - group[i]][Math.max(0, k - profit[i])] : 0;
                    f[j][k] = (a + b) % 1000000007;
                }
            }
        }
        return f[n][minProfit];
    }

}
