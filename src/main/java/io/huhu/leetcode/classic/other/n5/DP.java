package io.huhu.leetcode.classic.other.n5;

class DP implements Code {

    @Override
    public int solution(int[][] arr, int t) {
        int[] dp = new int[t + 1];
        for (int i = 1; i <= arr.length; i++) {
            for (int j = t; j >= arr[i - 1][0]; j--) {
                dp[j] = Integer.max(dp[j], dp[j - arr[i - 1][0]] + arr[i - 1][1]);
            }
        }
        return dp[t];
    }

}
