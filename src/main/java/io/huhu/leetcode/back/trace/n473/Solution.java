package io.huhu.leetcode.back.trace.n473;

/**
 * <a href="https://leetcode.cn/problems/matchsticks-to-square/submissions/483226904/">
 * 473.火柴拼正方形
 * </a>
 *
 * 你将得到一个整数数组matchsticks, 其中matchsticks[i]是第i个火柴棒的长度.
 * 你要用所有火柴棍拼成一个正方形.
 * 你不能折断任何一根火柴棒, 但你可以把它们连在一起, 而且每根火柴棒必须使用一次.
 *
 * 如果你能使这个正方形, 则返回true, 否则返回false.
 */
class Solution {

    /**
     * 1 <= matchsticks.length <= 15
     * 1 <= matchsticks[i] <= 10^8
     */
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        return dfs(matchsticks, new boolean[matchsticks.length], 0, 0, 0, 0);
    }

    /**
     * 深度优先遍历
     */
    private boolean dfs(int[] matchsticks, boolean[] used, int t, int b, int l, int r) {
        return false;
    }

}
