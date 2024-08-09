package io.huhu.leetcode.dynamic.programming.hard.n312;

class DP implements Solution {

    @Override
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = arr[i - 1] * arr[i] * arr[i + 1];
        }
        for (int l = n - 1; l >= 1; l--) {
            for (int r = l + 1; r <= n; r++) {
                int score = Math.max(
                        arr[l - 1] * arr[l] * arr[r + 1] + dp[l + 1][r],
                        arr[l - 1] * arr[r] * arr[r + 1] + dp[l][r - 1]);
                for (int i = l + 1; i < r; i++) {
                    score = Math.max(score, dp[l][i - 1] + arr[l - 1] * arr[i] * arr[r + 1] + dp[i + 1][r]);
                }
                dp[l][r] = score;
            }
        }
        return dp[1][n];
    }

}
