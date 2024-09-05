package io.huhu.leetcode.dynamic.programming.hard.n1655;

import java.util.Arrays;

class DP implements Solution {

    @Override
    public boolean canDistribute(int[] nums, int[] quantity) {
        int[] numsCnt = countNums(nums), quantityCnt = countStatus(quantity);
        int n = numsCnt.length, m = 1 << quantity.length;
        boolean[][] dp = new boolean[n + 1][m];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j < m; j++) {
                boolean ans = false;
                for (int s = j; !ans && s > 0; s = (s - 1) & j) {
                    if ((j ^ s) >= 0 && quantityCnt[s] <= numsCnt[i] && dp[i + 1][j ^ s]) {
                        ans = true;
                    }
                }
                if (!ans) {
                    ans = dp[i + 1][j];
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][m - 1];
    }

    private int[] countStatus(int[] quantity) {
        int n = 1 << quantity.length;
        int[] ans = new int[n];
        for (int i = 0; i < quantity.length; i++) {
            int h = 1 << i, v = quantity[i];
            for (int j = 0; j < h; j++) {
                ans[j | h] = ans[j] + v;
            }
        }
        return ans;
    }

    private int[] countNums(int[] nums) {
        Arrays.sort(nums);
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                n++;
            }
        }
        int c = 1;
        int[] ans = new int[n];
        for (int i = 1, j = 0; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
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
