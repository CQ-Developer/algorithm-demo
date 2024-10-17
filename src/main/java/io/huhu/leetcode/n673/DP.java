package io.huhu.leetcode.n673;

class DP implements Code {

    @Override
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int len = 0, ans = 0;
        // f[i]表示以第i个数字结尾的最长递增子序列的长度
        // g[i]表示以第i个数字结尾的最长递增子序列的数量
        int[] f = new int[n], g = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = g[i] = 1;
            for (int j = 0; j < i; j++) {
                // nums[i]可以在nums[j]的基础上形成更长的递增序列
                if (nums[j] < nums[i]) {
                    if (f[j] + 1 > f[i]) {
                        // 形成更长的递增序列
                        f[i] = f[j] + 1;
                        // nums[i]可以和之前所有以nums[j]结尾的递增序列形成更长的递增序列
                        // 之前以nums[j]结尾的递增序列有dp[j]个, 则更长的序列也为dp[j]个
                        g[i] = g[j];
                    } else if (f[j] + 1 == f[i]) {
                        // 形成相同长度的最长递增序列
                        g[i] += g[j];
                    }
                }
            }
            if (f[i] > len) {
                len = f[i];
                ans = g[i];
            } else if (len == f[i]) {
                ans += g[i];
            }
        }
        return ans;
    }

}
