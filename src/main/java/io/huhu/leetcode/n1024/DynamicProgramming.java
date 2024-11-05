package io.huhu.leetcode.n1024;

class DynamicProgramming implements Code {

    private static final int MAX = 101;

    @Override
    public int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        for (int i = 1; i <= time; i++) {
            dp[i] = MAX;
        }
        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                int f = clip[0];
                if (f < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[f] + 1);
                }
            }
        }
        if (dp[time] == MAX) {
            return -1;
        }
        return dp[time];
    }

}
