package io.huhu.leetcode.n473;

import java.util.Arrays;

class BT implements Code {

    @Override
    public boolean makesquare(int[] matchsticks) {
        int edge = 0;
        for (int matchstick : matchsticks) {
            edge += matchstick;
        }
        if (edge % 4 != 0) {
            return false;
        }
        edge >>= 2;
        Arrays.sort(matchsticks);
        int n = matchsticks.length;
        if (matchsticks[n - 1] > edge) {
            return false;
        }
        return f(matchsticks, n - 1, edge, new int[4]);
    }

    /**
     * @param sticks 火柴
     * @param i      当前要放置第i根火柴
     * @param edge   边长
     * @param side   每条边的长度
     */
    private boolean f(int[] sticks, int i, int edge, int[] side) {
        if (i < 0) {
            return true;
        }
        for (int j = 0; j < side.length; j++) {
            if (sticks[i] + side[j] > edge) {
                continue;
            }
            if (j > 0 && side[j - 1] < edge && side[j] == side[j - 1]) {
                continue;
            }
            side[j] += sticks[i];
            if (f(sticks, i - 1, edge, side)) {
                return true;
            }
            side[j] -= sticks[i];
        }
        return false;
    }

}
