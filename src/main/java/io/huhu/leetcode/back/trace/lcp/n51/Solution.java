package io.huhu.leetcode.back.trace.lcp.n51;

/**
 * <a href="https://leetcode.cn/problems/UEcfPD/">LCP 51.烹饪料理</a>
 * 欢迎各位勇者来到力扣城, 城内设有烹饪锅供勇者制作料理, 为自己恢复状态.
 * 勇者背包内共有编号0~4的五种食材, 其中materials[j]表示第j种食材的数量.
 * 通过这种食材可以制作若干料理, cookbooks[i][j]表示制作第i种料理需要第j种食材的数量,
 * 而attribute[i]=[x,y]表示第i道料理的美味度x和饱腹感y.
 * 在饱腹感不小于limit的情况下, 请返回勇者可获得的最大美味度.
 * 如果无法满足饱腹感要求, 则返回-1.
 * 注意: 每种材料只能制作一次.
 */
class Solution {

    /**
     * materials.length == 5
     * 1 <= cookbooks.length == attribute.length <= 8
     * cookbooks[i].length == 5
     * attribute[i].length == 2
     * 0 <= materials[i], cookbook[i][j], attribute[i][j] <= 20
     * 1 <= limit <= 100
     */
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int[] result = {-1};
        backTrace(cookbooks, new boolean[cookbooks.length], materials, attribute, limit, 0, 0, result);
        return result[0];
    }

    /**
     * 回溯算法
     */
    private void backTrace(int[][] cookbooks, boolean[] isCooked, int[] materials, int[][] attribute, int limit, int x, int y, int[] result) {
        // 料理饱腹感达标且美味度更高
        if (y >= limit && x > result[0]) {
            result[0] = x;
        }
        for (int i = 0; i < cookbooks.length; i++) {
            // 料理已烹饪过
            if (isCooked[i]) {
                continue;
            }
            // 判断剩余材料是否能烹饪料理
            boolean canNotCook = false;
            for (int j = 0; j < cookbooks[i].length; j++) {
                if (materials[j] < cookbooks[i][j]) {
                    canNotCook = true;
                    break;
                }
            }
            if (canNotCook) {
                continue;
            }
            // 设置状态: 设置已烹饪状态, 减去材料数量
            isCooked[i] = true;
            for (int j = 0; j < cookbooks[i].length; j++) {
                materials[j] -= cookbooks[i][j];
            }
            // 递归
            backTrace(cookbooks, isCooked, materials, attribute, limit, x + attribute[i][0], y + attribute[i][1], result);
            // 回溯状态: 回滚烹饪状态, 回滚材料状态
            for (int j = 0; j < cookbooks[i].length; j++) {
                materials[j] += cookbooks[i][j];
            }
            isCooked[i] = false;
        }
    }

}
