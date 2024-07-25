package io.huhu.leetcode.classic.other.n5;

class DP implements Code {

    @Override
    public int solution(int[][] arr, int t) {
        int[] dp = new int[t + 1];
        for (int[] nums : arr) {
            for (int j = t; j >= nums[0]; j--) {
                dp[j] = Integer.max(dp[j], dp[j - nums[0]] + nums[1]);
            }
        }
        return dp[t];
    }

}
