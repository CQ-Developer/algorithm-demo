package io.huhu.leetcode.dynamic.programming.medium.n397;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/integer-replacement/description/">Integer Replacement</a>
 * </h1>
 * <p>Given a positive integer n, you can apply one of the following operations:</p>
 * <ul>
 * <li>if n is even, replace n with n / 2</li>
 * <li>if n is odd, replace n with either n + 1 or n - 1</li>
 * </ul>
 * <p>Return the minimum number of operations needed for n to become 1</p>
 */
class Solution {

    /**
     * 1 &lt;= n &lt;= 2<sup>31</sup> - 1
     */
    public int integerReplacement(int n) {
        return backTracing(n, new HashMap<>());
    }

    private int backTracing(long n, Map<Long, Integer> map) {
        if (n == 1) {
            return 0;
        }
        if (map.get(n) != null) {
            return map.get(n);
        }
        int ans = 1;
        if ((n & 1) == 1) {
            ans += Math.min(backTracing(n - 1, map), backTracing(n + 1, map));
        } else {
            ans += backTracing(n >> 1, map);
        }
        map.put(n, ans);
        return ans;
    }

}
