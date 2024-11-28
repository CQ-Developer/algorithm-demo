package io.huhu.leetcode.n1696;

import io.huhu.TLE;

@TLE
class DynamicProgramming implements Code {

    @Override
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int t = Integer.MIN_VALUE;
            for (int j = Math.max(i - k, 0); j < i; j++) {
                t = Math.max(t, f[j]);
            }
            f[i] = t + nums[i];
        }
        return f[n - 1];
    }

}
