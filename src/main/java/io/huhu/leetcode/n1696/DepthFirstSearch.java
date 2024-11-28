package io.huhu.leetcode.n1696;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Code {

    @Override
    public int maxResult(int[] nums, int k) {
        return f(nums, k, nums.length - 1);
    }

    private int f(int[] nums, int k, int i) {
        if (i == 0) {
            return nums[0];
        }
        int ans = Integer.MIN_VALUE;
        for (int j = Math.max(0, i - k); j < i; j++) {
            ans = Math.max(ans, f(nums, k, j));
        }
        return ans + nums[i];
    }

}
