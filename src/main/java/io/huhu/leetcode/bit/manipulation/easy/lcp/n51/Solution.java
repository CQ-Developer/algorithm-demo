package io.huhu.leetcode.bit.manipulation.easy.lcp.n51;

/**
 * <a href="https://leetcode.cn/problems/UEcfPD/description/">烹饪料理</a>
 */
class Solution {

    /**
     * <ul>
     * <li>materials.length == 5</li>
     * <li>1 <= cookbooks.length == attribute.length <= 8</li>
     * <li>cookbooks[i].length == 5</li>
     * <li>attribute.length == 2</li>
     * <li>0 <= materials[i], cookbooks[i][j], attribute[i][i] <= 20</li>
     * <li>1 <= limit <= 100</li>
     * </ul>
     */
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int m = materials.length, n = cookbooks.length, max = -1;
        /*
         * 位运算
         * 假设可以做3种料理, 则能做出(2^3)-1=7种料理组合, 0不算
         * 观察其二进制表示如下
         * 001
         * 010
         * 011
         * 100
         * 101
         * 110
         * 111
         * 二进制表示中为1的位表示制作这种料理
         * 通过枚举所有的二进制位, 能够计算出所有料理组合的美味度
         * 取美味度最高的即可
         */
        out:
        for (int cook = 1; cook < (1 << n); cook++) {
            // 统计制作当前料理组合的食材消耗、美味度、饱腹感
            int x = 0, y = 0;
            int[] cost = new int[m];
            for (int i = 0; i < n; i++) {
                // 第i位不是1则不做这种料理
                if ((cook >> i & 1) == 0) {
                    continue;
                }
                x += attribute[i][0];
                y += attribute[i][1];
                for (int j = 0; j < m; j++) {
                    cost[j] += cookbooks[i][j];
                }
            }
            // 判断饱腹感是否满足要求
            if (y < limit) {
                continue;
            }
            // 判断食材消耗是否超限, 注意这里直接continue到最外层循环寻找下一种组合
            for (int j = 0; j < m; j++) {
                if (cost[j] > materials[j]) {
                    continue out;
                }
            }
            // 统计最大美味度
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

}
