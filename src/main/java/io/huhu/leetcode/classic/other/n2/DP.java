package io.huhu.leetcode.classic.other.n2;

class DP implements Code {

    @Override
    public int maximumSumOfSubarray(int[] nums) {
        int n = nums.length;
        int[] start = new int[n];
        start[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            start[i] = Integer.max(nums[i], nums[i] + start[i + 1]);
        }
        int ans = start[0], end = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
            ans = Integer.max(ans, max + start[i]);
            end = Integer.max(nums[i], nums[i] + end);
            max = Integer.max(max, end);
        }
        return Integer.max(ans, max);
    }

}
