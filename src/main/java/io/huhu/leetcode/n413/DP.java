package io.huhu.leetcode.n413;

class DP implements Code {

    /**
     * dp[i]表示以第i个数字作为结尾的等差数列的数量
     */
    @Override
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }

}
