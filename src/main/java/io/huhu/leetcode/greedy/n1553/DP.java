package io.huhu.leetcode.greedy.n1553;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: TLE
 */
class DP implements Code {

    @Override
    public int minDays(int n) {
        if (n <= 2) {
            return n;
        }
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);
        dp.put(2, 2);
        for (int i = 3; i <= n; i++) {
            int min = Math.min(i % 2 + dp.getOrDefault(i / 2, 0), i % 3 + dp.getOrDefault(i / 3, 0)) + 1;
            dp.put(i, min);
        }
        return dp.get(n);
    }

}
