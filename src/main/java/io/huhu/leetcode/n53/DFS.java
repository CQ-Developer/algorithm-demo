package io.huhu.leetcode.n53;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int maxSubArray(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, Integer.MIN_VALUE);
        int ans = f(nums, nums.length - 1, cache);
        for (int max : cache) {
            ans = Math.max(ans, max);
        }
        return ans;
    }

    private int f(int[] nums, int i, int[] cache) {
        if (i == 0) {
            return cache[i] = nums[i];
        }
        if (cache[i] != Integer.MIN_VALUE) {
            return cache[i];
        }
        return cache[i] = Math.max(nums[i], nums[i] + f(nums, i - 1, cache));
    }

}
