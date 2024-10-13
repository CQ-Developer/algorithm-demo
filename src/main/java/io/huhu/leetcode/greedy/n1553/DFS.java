package io.huhu.leetcode.greedy.n1553;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: StackOverflowError
 */
class DFS implements Code {

    @Override
    public int minDays(int n) {
        return f(n, new HashMap<>());
    }

    private int f(int n, Map<Integer, Integer> map) {
        if (n <= 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ans = f(n - 1, map);
        if (n % 3 == 0) {
            ans = Math.min(ans, f(n / 3, map));
        }
        if (n % 2 == 0) {
            ans = Math.min(ans, f(n / 2, map));
        }
        map.put(n, ++ans);
        return ans;
    }

}
