package io.huhu.leetcode.dynamic.programming.medium.n473;

import java.util.Arrays;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/matchsticks-to-square/description/">Matchsticks to Square</a>
 * </h1>
 * <p>You are given an integer array matchsticks where matchsticks[i] is the length
 * of the i<sub>th</sub> matchstick. You want to use all the matchsticks to make
 * one square. You should not break any stick, but you can link them up, and each
 * matchstick must be used exactly one time.</p>
 * <p>Return true if you can make this square and false otherwise.</p>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= matchsticks.length <= 15</li>
     * <li>1 <= matchsticks[i] <= 10<sup>8</sup></li>
     * </ul>
     */
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        return backTracing(matchsticks, matchsticks.length - 1, new int[4], sum >> 2);
    }

    private boolean backTracing(int[] matchsticks, int j, int[] edges, int target) {
        if (j < 0) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] + matchsticks[j] > target) {
                continue;
            }
            if (i > 0 && edges[i - 1] < target && edges[i - 1] == edges[i]) {
                continue;
            }
            edges[i] += matchsticks[j];
            if (backTracing(matchsticks, j - 1, edges, target)) {
                return true;
            }
            edges[i] -= matchsticks[j];
        }
        return false;
    }

}
