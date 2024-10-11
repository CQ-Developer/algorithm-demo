package io.huhu.leetcode.n413;

class DFS implements Code {

    @Override
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        for (int i = 2; i < nums.length; i++) {
            ans += f(nums, i);
        }
        return ans;
    }

    private int f(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
            return f(nums, i + 1) + 1;
        }
        return 0;
    }

}
