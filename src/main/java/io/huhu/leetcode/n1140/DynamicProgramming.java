package io.huhu.leetcode.n1140;

class DynamicProgramming implements Code {

    @Override
    public int stoneGameII(int[] piles) {
        int n = piles.length, sum = 0;
        /*
         * dp数组的第二维边界问题:
         * i的最大边界为: i <= n - 1
         * m的最大边界为: m <= i / 2 + 1
         * 得到m的最大边界为: 2m <= n + 1
         * x的最大边界为: x <= 2m
         * 得到x的最大边界为 x <= n + 1, 然后石头最多有n堆
         * 即: x <= n
         */
        int[][] f = new int[n][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sum += piles[i];
            /*
             * m的取值范围问题:
             * 假设每轮从i开始选择2m堆石子则
             * i = 2 + 4 + 8 + ... + M
             * 注意m从1开始, 即在假设每轮都选择2m堆石子的情况下, 第一轮可以选2堆
             * 同时本轮最多能选择m堆, 即最后一轮选择m堆
             * 根据等比数列求和公式可得:
             * i = 2m - 2
             * 假设每轮不那么极端的都选2m堆石子, 那么
             * i >= 2m - 2
             * 求得m的取值范围为
             * m <= i / 2 + 1
             */
            for (int m = i / 2 + 1; m >= 1; m--) {
                if (i + 2 * m >= n) {
                    f[i][m] = sum;
                } else {
                    int ans = Integer.MAX_VALUE;
                    for (int x = 1; x <= 2 * m; x++) {
                        ans = Math.min(ans, f[i + x][Math.max(x, m)]);
                    }
                    f[i][m] = sum - ans;
                }
            }
        }
        return f[0][1];
    }

}
