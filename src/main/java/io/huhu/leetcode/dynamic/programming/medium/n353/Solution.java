package io.huhu.leetcode.dynamic.programming.medium.n353;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.cn/problems/integer-break/description/">Integer Break</a></h1>
 */
class Solution {

    public int integerBreak(int n) {
        return dfs(n, new HashMap<>());
    }

    private int dfs(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int max = 1;
        for (int i = 1; i < (n >> 1) + 1; i++) {
            max = Math.max(max, Math.max(i * (n - i), i * dfs(n - i, cache)));
        }
        cache.put(n, max);
        return max;
    }

}
