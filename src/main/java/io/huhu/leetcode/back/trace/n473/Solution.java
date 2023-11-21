package io.huhu.leetcode.back.trace.n473;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/matchsticks-to-square/submissions/483226904/">473.火柴拼正方形</a>
 * 你将得到一个整数数组matchsticks, 其中matchsticks[i]是第i个火柴棒的长度.
 * 你要用所有火柴棍拼成一个正方形.
 * 你不能折断任何一根火柴棒, 但你可以把它们连在一起, 而且每根火柴棒必须使用一次.
 * 如果你能使这个正方形, 则返回true, 否则返回false.
 */
class Solution {

    /**
     * 1 <= matchsticks.length <= 15
     * 1 <= matchsticks[i] <= 10^8
     */
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int matchstick : matchsticks) {
            total += matchstick;
        }
        if (total % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        return dfs(matchsticks, matchsticks.length - 1, new int[4], total / 4);
    }

    /**
     * 深度优先遍历
     * <a href="https://leetcode.cn/problems/matchsticks-to-square/solutions/615092/hui-su-suan-fa-jie-jue-ji-you-hua-chao-g-9iyl/">解题思路</a>
     */
    private boolean dfs(int[] matchsticks, int j, int[] sides, int len) {
        // 所有火柴都放完了
        if (j < 0) {
            return true;
        }
        for (int i = 0; i < sides.length; i++) {
            // 如果把火柴放进当前边大于len,
            if (sides[i] + matchsticks[j] > len) {
                continue;
            }
            // 如果前一条边没有放成功, 且当前边和前一条边相等
            // 那么放在当前边的结果和前一条一样肯定不会成功, 直接跳过
            if (i > 0 && sides[i - 1] < len && sides[i - 1] == sides[i]) {
                continue;
            }
            sides[i] += matchsticks[j];
            if (dfs(matchsticks, j - 1, sides, len)) {
                return true;
            }
            sides[i] -= matchsticks[j];
        }
        return false;
    }

}
