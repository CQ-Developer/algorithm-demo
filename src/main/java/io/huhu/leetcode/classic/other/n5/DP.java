package io.huhu.leetcode.classic.other.n5;

class DP implements Code {

    @Override
    public int solution(int[][] arr, int t) {
        int[][] dp = new int[arr.length + 1][t + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - arr[i - 1][0] >= 0) {
                    dp[i][j] = Integer.max(dp[i][j], dp[i - 1][j - arr[i - 1][0]] + arr[i - 1][1]);
                }
            }
        }
        return dp[arr.length][t];
    }

}
