package io.huhu.leetcode.dynamic.programming.easy.lcp07;

/**
 * <a href="https://leetcode.cn/problems/chuan-di-xin-xi/description/">传递信息</a>
 */
class Solution {

    public int numWays(int n, int[][] relation, int k) {
        int[][] f = new int[k + 1][n];
        // 第0轮传递到编号为0的小朋友的方案数量
        f[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] r : relation) {
                // 第i轮消息能传递到小朋友r[1]的方案数量 = 上一轮(第i-1轮)消息传递传递到小朋友r[0]的方案数 + 本轮(第i轮)消息传递到小朋友r[1]的方案数量
                // 注意: 消息传递方式 r[0] -> r[1]
                f[i][r[1]] += f[i - 1][r[0]];
            }
        }
        return f[k][n - 1];
    }

}
