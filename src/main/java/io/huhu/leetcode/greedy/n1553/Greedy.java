package io.huhu.leetcode.greedy.n1553;

import java.util.HashMap;
import java.util.Map;

class Greedy implements Code {

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
        int ans = Math.min(n % 2 + f(n / 2, map) + 1, n % 3 + f(n / 3, map) + 1);
        map.put(n, ans);
        return ans;
    }

}
