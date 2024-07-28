package io.huhu.leetcode.dynamic.programming.medium.n1049;

import java.util.HashMap;
import java.util.Map;

class DFS implements Solution {

    @Override
    public int lastStoneWeightII(int[] stones) {
        return dfs(stones, 0, 0, 0, new HashMap<>());
    }

    private int dfs(int[] stones, int i, int a, int b, Map<Integer, Map<Integer, Map<Integer, Integer>>> cache) {
        if (i == stones.length) {
            return Math.abs(a - b);
        }
        if (cache.containsKey(i) && cache.get(i).containsKey(a) && cache.get(i).get(a).containsKey(b)) {
            return cache.get(i).get(a).get(b);
        }
        int x = dfs(stones, i + 1, a + stones[i], b, cache);
        int y = dfs(stones, i + 1, a, b + stones[i], cache);
        int ans = Integer.min(x, y);
        cache.putIfAbsent(i, new HashMap<>());
        Map<Integer, Map<Integer, Integer>> map = cache.get(i);
        map.putIfAbsent(a, new HashMap<>());
        map.get(a).put(b, ans);
        return ans;
    }

}
