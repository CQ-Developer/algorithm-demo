package io.huhu.leetcode.back.trace.n473;

import java.util.Arrays;

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
        if (matchsticks.length == 4) {
            int side = matchsticks[0];
            for (int i = 1; i < matchsticks.length; i++) {
                if (matchsticks[i] != side) {
                    return false;
                }
            }
            return true;
        }
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        int side = sum / 4;
        if (sum != side * 4) {
            return false;
        }
        Arrays.sort(matchsticks);
        boolean[] result = {false};
        dfs(matchsticks, new boolean[matchsticks.length], side, new int[4], 0, result);
        return result[0];
    }

    /**
     * 深度优先遍历
     */
    private void dfs(int[] matchsticks, boolean[] used, int side, int[] path, int i, boolean[] result) {
        if (i == 4) {
            System.out.println("命中✔ " + Arrays.toString(path));
            result[0] = path[0] == side && path[1] == side && path[2] == side && path[3] == side;
            return;
        }
        for (int j = matchsticks.length - 1; j >= 0 && !result[0]; j--) {
            if (used[j]) {
                continue;
            }
            int k = -1;
            if (path[i] + matchsticks[j] < side) {
                k = i;
            } else if (path[i] + matchsticks[j] == side) {
                k = i + 1;
            }
            if (k == -1) {
                return;
            }
            used[j] = true;
            path[i] += matchsticks[j];
            System.out.println("递归前 " + Arrays.toString(path));
            dfs(matchsticks, used, side, path, k, result);
            path[i] -= matchsticks[j];
            used[j] = false;
            System.out.println("回溯后 " + Arrays.toString(path));
        }
    }

}
