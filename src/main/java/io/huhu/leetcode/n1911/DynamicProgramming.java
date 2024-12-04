package io.huhu.leetcode.n1911;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        // f[i]: 从前i个元素中选出子序列, 且最后一个元素为奇数下标, 最大交替和
        long[] f = new long[n + 1];
        // g[i]: 从前i个元素中选出子序列, 且最后一个元素为偶数下标, 最大交替和
        long[] g = new long[n + 1];
        // dp
        for (int i = 0; i < n; i++) {
            f[i + 1] = Math.max(f[i], g[i] - nums[i]);
            g[i + 1] = Math.max(g[i], f[i] + nums[i]);
        }
        return Math.max(f[n], g[n]);
    }

}
