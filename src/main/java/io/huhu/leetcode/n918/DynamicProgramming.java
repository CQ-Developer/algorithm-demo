package io.huhu.leetcode.n918;

class DynamicProgramming implements Code {

    @Override
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0];
        int maxPre = nums[0], _maxPre = nums[0];
        int minPre = nums[0], _minPre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            // 子数组最大累加和
            _maxPre = Math.max(nums[i], nums[i] + _maxPre);
            maxPre = Math.max(maxPre, _maxPre);
            // 子数组的最小累加和
            _minPre = Math.min(nums[i], nums[i] + _minPre);
            minPre = Math.min(minPre, _minPre);
        }
        // sum == minPre 是空数组的情况
        return sum == minPre ? maxPre : Math.max(maxPre, sum - minPre);
    }

}
