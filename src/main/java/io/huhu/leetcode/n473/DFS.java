package io.huhu.leetcode.n473;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public boolean makesquare(int[] matchsticks) {
        int m = perimeter(matchsticks);
        if (m % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        return f(matchsticks, (1 << matchsticks.length) - 1, m >> 2, 0, 4);
    }

    /**
     * @param s 记录哪些火柴使用过了
     * @param n 每条边的长度
     * @param c 当前放置的边的长度
     * @param r 剩余边的数量
     */
    private boolean f(int[] matchstick, int s, int n, int c, int r) {
        if (r == 0) {
            return s == 0;
        }
        boolean ans = false;
        for (int i = matchstick.length - 1; i >= 0 && !ans; i--) {
            if (((1 << i) & s) != 0) {
                if (c + matchstick[i] == n) {
                    ans = f(matchstick, s ^ (1 << i), n, 0, r - 1);
                } else if (c + matchstick[i] < n) {
                    ans = f(matchstick, s ^ (1 << i), n, c + matchstick[i], r);
                }
            }
        }
        return ans;
    }

    private int perimeter(int[] matchsticks) {
        int perimeter = 0;
        for (int matchstick : matchsticks) {
            perimeter += matchstick;
        }
        return perimeter;
    }

}
