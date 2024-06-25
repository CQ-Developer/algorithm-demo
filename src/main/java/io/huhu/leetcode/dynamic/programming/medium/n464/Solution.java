package io.huhu.leetcode.dynamic.programming.medium.n464;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/can-i-win/description/">Can I Win</a>
 * </h1>
 * <p>In the "100 game" two players take turns adding, to a running total,
 * any integer from 1 to 10. The player who first causes the running total
 * to reach or exceed 100 wins.</p>
 * <p>What if we change the game so that players cannot re-use integers?</p>
 * <p>For example, two players might take turns drawing from a common pool
 * of numbers from 1 to 15 without replacement until they reach a total >= 100.</p>
 * <p>Given two integers maxChoosableInteger and desiredTotal, return true if
 * the first player to move can force a win, otherwise, return false.
 * Assume both players play optimally.</p>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= maxChoosableInteger <= 20</li>
     * <li>0 <= desiredTotal <= 300</li>
     * </ul>
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0 || maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        return dfs(0, maxChoosableInteger, desiredTotal, new byte[1 << 21]) == 1;
    }

    private int dfs(int s, int n, int d, byte[] f) {
        if (f[s] != 0) {
            return f[s];
        }
        for (int i = 1; i <= n; i++) {
            if (((1 << i) & s) != 0) {
                continue;
            }
            if (d - i <= 0 || dfs((1 << i) | s, n, d - i, f) == -1) {
                return f[s] = 1;
            }
        }
        return f[s] = -1;
    }

}
