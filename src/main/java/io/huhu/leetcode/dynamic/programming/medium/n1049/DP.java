package io.huhu.leetcode.dynamic.programming.medium.n1049;

class DP implements Solution {

    @Override
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int m = sum >> 1;
        int[] dp = new int[m + 1];
        for (int stone : stones) {
            for (int i = m; i >= stone; i--) {
                dp[i] = Integer.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - dp[m] - dp[m];
    }

}
