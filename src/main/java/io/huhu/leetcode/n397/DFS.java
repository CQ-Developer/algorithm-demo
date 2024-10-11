package io.huhu.leetcode.n397;

import java.util.HashMap;
import java.util.Map;

class DFS implements Code {

    @Override
    public int integerReplacement(int n) {
        return (int) f(n, new HashMap<>());
    }

    private long f(long n, Map<Long, Long> dp) {
        if (n == 1) {
            return 0;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        long ans = (n & 1) == 1 ? Math.min(f(n - 1, dp), f(n + 1, dp)) : f(n >> 1, dp);
        dp.put(n, ++ans);
        return ans;
    }

}
