package io.huhu.leetcode.n1262;

class DepthFirstSearch implements Code {

    @Override
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        return f(nums, n - 1, 0);
    }

    /**
     * 在 0...i 之间选择 maxSum % 3 == j 的 maxSum
     */
    private int f(int[] nums, int i, int j) {
        if (i == -1) {
            return j == 0 ? 0 : Integer.MIN_VALUE;
        }
        // 选择nums[i]与不选择nums[i]
        return Math.max(f(nums, i - 1, j), f(nums, i - 1, (j + nums[i]) % 3) + nums[i]);
    }

}
