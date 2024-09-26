package io.huhu.leetcode.n45;

class DP implements Code {

    @Override
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= n - 1) {
                dp[i] = 1;
            } else {
                int ans = Integer.MAX_VALUE;
                for (int j = 1; j <= nums[i]; j++) {
                    int next = dp[i + j];
                    if (next != Integer.MAX_VALUE) {
                        ans = Math.min(ans, next + 1);
                    }
                }
                dp[i] = ans;
            }
        }
        return dp[0];
    }

}
