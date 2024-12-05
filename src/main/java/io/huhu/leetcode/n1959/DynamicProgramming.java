package io.huhu.leetcode.n1959;

import java.util.Arrays;

class DynamicProgramming implements Solution {

    /**
     * 如果只能调整1次, 那么一定是调整到最大值,
     * 空间浪费 = 最大值 * n - 数组和
     */
    @Override
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;
        // 前缀和: 快速计算数组指定区间的和
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        // 在l...r范围上只调整1次的空间浪费
        int[][] cost = new int[n][n];
        for (int l = 0; l < n; l++) {
            int mx = 0;
            for (int r = l; r < n; r++) {
                mx = Math.max(mx, nums[r]);
                cost[l][r] = mx * (r - l + 1) - (pre[r + 1] - pre[l]);
            }
        }
        // dp: f[i][j]表示在前i个数调整j次的最小空间浪费
        int[][] f = new int[n + 1][k + 2];
        for (int[] _f : f) {
            Arrays.fill(_f, Integer.MAX_VALUE);
        }
        // 枚举前i个数
        for (int i = 1; i <= n; i++) {
            // 在0..i范围上调整1次
            f[i][1] = cost[0][i - 1];
            // 调整k+1次: 前i个数最多调整i次, 总共最多调整k+1次
            for (int j = 2; j <= Math.min(i, k + 1); j++) {
                // 枚举 0..._i...i 范围上
                // 假设在 0..._i 范围上进行了j-1次调整, 那么在 _i...i 范围上需要进行1次调整
                // j-1开始主要是减少重复计算, 因为调整次数越少空间浪费越少, 所以不用每次从1开始枚举
                // 改成1也行, 上面填充f数组时, 改成Arrays.fill(_f, Integer.MAX_VALUE / 2)防止整数越界
                for (int _i = j - 1; _i < i; _i++) {
                    f[i][j] = Math.min(f[i][j], f[_i][j - 1] + cost[_i][i - 1]);
                }
            }
        }
        return f[n][k + 1];
    }

}
