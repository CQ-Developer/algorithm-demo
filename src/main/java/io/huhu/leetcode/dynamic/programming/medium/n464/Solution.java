package io.huhu.leetcode.dynamic.programming.medium.n464;

/**
 * <a href="https://leetcode.cn/problems/can-i-win/description/">
 * Can I Win
 * </a>
 */
class Solution {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        if ((maxChoosableInteger * (maxChoosableInteger + 1)) >> 1 < desiredTotal) {
            return false;
        }
        return f(maxChoosableInteger, desiredTotal, 0, new int[1 << (maxChoosableInteger + 1)]);
    }

    private boolean f(int n, int m, int s, int[] dp) {
        // 当前轮玩家已经输了
        if (m <= 0) {
            return false;
        }
        if (dp[s] != 0) {
            return dp[s] == 1;
        }
        dp[s] = -1;
        for (int i = 1; i <= n && dp[s] == -1; i++) {
            // 下一轮必然是后出手的玩家选择
            if (((1 << i) & s) == 0 && !f(n, m - i, s ^ (1 << i), dp)) {
                dp[s] = 1;
            }
        }
        return dp[s] == 1;
    }

}
