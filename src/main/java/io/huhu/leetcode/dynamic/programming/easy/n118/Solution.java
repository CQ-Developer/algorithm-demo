package io.huhu.leetcode.dynamic.programming.easy.n118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle/description/">杨辉三角</a>
 */
class Solution {

    public List<List<Integer>> generate(int numRows) {
        Integer[][] dp = new Integer[numRows][];
        for (int i = 0; i < numRows; i++) {
            dp[i] = new Integer[i + 1];
            dp[i][0] = dp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Integer[] a : dp) {
            res.add(Arrays.asList(a));
        }
        return res;
    }

}
