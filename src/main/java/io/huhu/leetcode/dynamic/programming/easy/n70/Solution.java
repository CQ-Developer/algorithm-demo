package io.huhu.leetcode.dynamic.programming.easy.n70;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/">爬楼梯</a>
 */
class Solution {

    private final Map<Integer, Integer> cache = new HashMap<>();

    /**
     * 动态规划
     */
    public int climbStairs(int n) {
        if (n < 4) {
            return n;
        }
        int res = cache.getOrDefault(n, -1);
        if (res != -1) {
            return res;
        }
        res = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, res);
        return res;
    }

}
