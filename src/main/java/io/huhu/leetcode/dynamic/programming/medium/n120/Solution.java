package io.huhu.leetcode.dynamic.programming.medium.n120;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/triangle/description/">三角形最小路径和</a>
 */
class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j + 1], dp[j]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

}
