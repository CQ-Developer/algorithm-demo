package io.huhu.leetcode.n473;

import java.util.Arrays;

class BT implements Code {

    @Override
    public boolean makesquare(int[] matchsticks) {
        int m = count(matchsticks);
        if (m % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        return f(matchsticks, matchsticks.length - 1, m >> 2, new int[4]);
    }

    /**
     * @param a 火柴
     * @param i 当前要放置第i根火柴
     * @param n 正方形的边长
     * @param b 每条边的长度
     */
    private boolean f(int[] a, int i, int n, int[] b) {
        if (i < 0) {
            return true;
        }
        for (int j = 0; j < b.length; j++) {
            if (a[i] + b[j] > n) {
                continue;
            }
            b[j] += a[i];
            if (f(a, i - 1, n, b)) {
                return true;
            }
            b[j] -= a[i];
        }
        return false;
    }

    private int count(int[] sticks) {
        int ans = 0;
        for (int stick : sticks) {
            ans += stick;
        }
        return ans;
    }

}
