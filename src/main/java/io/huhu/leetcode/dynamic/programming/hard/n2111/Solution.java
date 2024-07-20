package io.huhu.leetcode.dynamic.programming.hard.n2111;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-the-array-k-increasing/description/">
 * Minimum Operations to Make the Array K-Increasing
 * </a>
 */
class Solution {

    public int kIncreasing(int[] arr, int k) {
        int n = arr.length, ans = 0;
        int[] nums = new int[n];
        for (int i = 0; i < k; i++) {
            int size = 0;
            for (int j = i; j < n; j += k) {
                nums[size++] = arr[j];
            }
            ans += size - dp(nums, size);
        }
        return ans;
    }

    private int dp(int[] nums, int n) {
        int len = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int j = bs(dp, len, num);
            if (j == -1) {
                dp[len++] = num;
            } else {
                dp[j] = num;
            }
        }
        return len;
    }

    private int bs(int[] dp, int len, int num) {
        int l = 0, r = len - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (dp[m] > num) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

}
