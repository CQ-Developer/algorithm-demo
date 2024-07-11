package io.huhu.leetcode.dynamic.programming.medium.n918;

class DP implements Solution {

    @Override
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0], min = nums[0], all = nums[0];
        for (int i = 1, maxP = nums[0], minP = nums[0]; i < nums.length; i++) {
            all += nums[i];
            maxP = Integer.max(nums[i], nums[i] + maxP);
            max = Integer.max(max, maxP);
            minP = Integer.min(nums[i], nums[i] + minP);
            min = Integer.min(min, minP);
        }
        return min == all ? max : Integer.max(max, all - min);
    }

}
