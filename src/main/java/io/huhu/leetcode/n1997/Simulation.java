package io.huhu.leetcode.n1997;

import io.huhu.TLE;

@TLE
class Simulation implements Code {

    private static final int M = 1_000_000_007;

    @Override
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length, res = -1, i = 0, visited = 0;
        int[] f = new int[n];
        while (visited < n) {
            if (f[i] == 0) {
                visited++;
            }
            res = (res + 1) % M;
            i = ++f[i] % 2 == 0 ? (i + 1) % n : nextVisit[i];
        }
        return res;
    }

}
