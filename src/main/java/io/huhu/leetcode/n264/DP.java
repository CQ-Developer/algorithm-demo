package io.huhu.leetcode.n264;

class DP implements Code {

    @Override
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            int x = dp[a] * 2, y = dp[b] * 3, z = dp[c] * 5;
            dp[i] = Math.min(x, Math.min(y, z));
            if (dp[i] == x) {
                a++;
            }
            if (dp[i] == y) {
                b++;
            }
            if (dp[i] == z) {
                c++;
            }
        }
        return dp[n];
    }

}
