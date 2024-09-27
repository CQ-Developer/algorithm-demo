package io.huhu.leetcode.n53;

class DFS implements Code {

    private int ans = Integer.MIN_VALUE;

    @Override
    public int maxSubArray(int[] nums) {
        f(nums, nums.length - 1);
        return ans;
    }

    private int f(int[] nums, int i) {
        if (i == 0) {
            ans = Math.max(ans, nums[i]);
            return nums[i];
        }
        int max = Math.max(nums[i], nums[i] + f(nums, i - 1));
        ans = Math.max(ans, max);
        return max;
    }

}
