package io.huhu.leetcode.n45;

class DFS implements Code {

    @Override
    public int jump(int[] nums) {
        return f(nums, 0, new int[nums.length]);
    }

    private int f(int[] nums, int i, int[] dp) {
        if (i == nums.length - 1) {
            return 0;
        }
        if (i + nums[i] >= nums.length - 1) {
            return 1;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[i]; j++) {
            int next = f(nums, i + j, dp);
            if (next != Integer.MAX_VALUE) {
                ans = Math.min(ans, next + 1);
            }
        }
        return dp[i] = ans;
    }

}
