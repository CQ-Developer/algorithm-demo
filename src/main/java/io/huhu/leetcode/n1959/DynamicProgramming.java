package io.huhu.leetcode.n1959;

import java.util.Arrays;

class DynamicProgramming implements Solution {

    @Override
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;
        // 前缀和: 快速计算数组指定区间的和
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        // 在l...r范围上只调整一次的最小空间浪费
        int[][] cost = new int[n][n];
        for (int l = 0; l < n; l++) {
            int mx = 0;
            for (int r = l; r < n; r++) {
                mx = Math.max(mx, nums[r]);
                cost[l][r] = mx * (r - l + 1) - (pre[r + 1] - pre[l]);
            }
        }
        // dp
        int[][] f = new int[n + 1][k + 2];
        for (int[] _f : f) {
            Arrays.fill(_f, Integer.MAX_VALUE);
        }
        for (int i = 1; i <= n; i++) {
            // 在0..i范围上调整1次
            f[i][1] = cost[0][i - 1];
            // 前i个数最多调整i次, 总共最多调整k+1次
            int len = Math.min(i, k + 1);
            for (int j = 2; j <= len; j++) {
                for (int _i = j - 1; _i < i; _i++) {
                    f[i][j] = Math.min(f[i][j], f[_i][j - 1] + cost[_i][i - 1]);
                }
            }
        }
        return f[n][k + 1];
    }

}
