package io.huhu.leetcode.n464;

class DFS implements Code {

    @Override
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        // sum(1...n)
        if ((maxChoosableInteger * (maxChoosableInteger + 1)) >> 1 < desiredTotal) {
            return false;
        }
        return f(maxChoosableInteger, desiredTotal, 0, new int[1 << (maxChoosableInteger + 1)]);
    }

    private boolean f(int n, int m, int s, int[] dp) {
        if (m <= 0) {
            return false;
        }
        if (dp[s] != 0) {
            return dp[s] == 1;
        }
        dp[s] = -1;
        for (int i = 1; i <= n && dp[s] == -1; i++) {
            if (((1 << i) & s) == 0 && !f(n, m - i, s ^ (1 << i), dp)) {
                dp[s] = 1;
            }
        }
        return dp[s] == 1;
    }

}
