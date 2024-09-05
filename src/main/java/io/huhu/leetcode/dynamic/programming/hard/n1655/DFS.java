package io.huhu.leetcode.dynamic.programming.hard.n1655;

import java.util.Arrays;

class DFS implements Solution {

    @Override
    public boolean canDistribute(int[] nums, int[] quantity) {
        int[] counts = counts(nums), sums = sums(quantity);
        int[][] dp = new int[1 << quantity.length][counts.length];
        return f(sums, (1 << quantity.length) - 1, counts, 0, dp);
    }

    private boolean f(int[] status, int s, int[] nums, int i, int[][] dp) {
        if (s == 0) {
            return true;
        }
        if (i == nums.length) {
            return false;
        }
        if (dp[s][i] != 0) {
            return dp[s][i] == 1;
        }
        boolean ans = false;
        for (int j = s; !ans && j > 0; j = (j - 1) & s) {
            if (status[j] <= nums[i] && f(status, s ^ j, nums, i + 1, dp)) {
                ans = true;
            }
        }
        if (!ans) {
            ans = f(status, s, nums, i + 1, dp);
        }
        dp[s][i] = ans ? 1 : -1;
        return ans;
    }

    private int[] sums(int[] quantity) {
        int n = quantity.length;
        int[] ans = new int[1 << n];
        for (int i = 0; i < n; i++) {
            int h = 1 << i, v = quantity[i];
            for (int j = 0; j < h; j++) {
                ans[j | h] = ans[j] + v;
            }
        }
        return ans;
    }

    private int[] counts(int[] nums) {
        Arrays.sort(nums);
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                n++;
            }
        }
        int c = 1;
        int[] ans = new int[n];
        for (int i = 1, j = 0; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                ans[j++] = c;
                c = 1;
            } else {
                c++;
            }
        }
        ans[n - 1] = c;
        return ans;
    }

}
