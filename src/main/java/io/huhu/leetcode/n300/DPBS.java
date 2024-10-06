package io.huhu.leetcode.n300;

class DPBS implements Code {

    @Override
    public int lengthOfLIS(int[] nums) {
        int len = 0, n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int j = f(dp, len, nums[i]);
            if (j == -1) {
                dp[len++] = nums[i];
            } else {
                dp[j] = nums[i];
            }
        }
        return len;
    }

    private int f(int[] dp, int len, int num) {
        int l = 0, r = len - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (num <= dp[m]) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

}
