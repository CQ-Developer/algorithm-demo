package io.huhu.leetcode.dynamic.programming.easy.lcp07;

/**
 * <a href="https://leetcode.cn/problems/chuan-di-xin-xi/description/">传递信息</a>
 */
class Solution {

    public int numWays(int n, int[][] relation, int k) {
        return backTrace(0, n, relation, k);
    }

    private int backTrace(int i, int n, int[][] relations, int k) {
        if (k == 0) {
            return i == n - 1 ? 1 : 0;
        }
        int sum = 0;
        for (int[] relation : relations) {
            if (relation[0] != i) {
                continue;
            }
            sum += backTrace(relation[1], n, relations, k - 1);
        }
        return sum;
    }

}
