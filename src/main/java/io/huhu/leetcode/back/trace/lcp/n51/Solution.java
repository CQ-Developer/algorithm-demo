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
     * <ul>
     * <li>materials.length == 5</li>
     * <li>1 <= cookbooks.length == attribute.length <= 8</li>
     * <li>cookbooks[i].length == 5</li>
     * <li>attribute[i].length == 2</li>
     * <li>0 <= materials[i], cookbook[i][j], attribute[i][j] <= 20</li>
     * <li>1 <= limit <= 100</li>
     * </ul>
     */
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        return backTrace(cookbooks, new boolean[cookbooks.length], materials, attribute, limit, 0, 0);
    }

    /**
     * 回溯算法
     */
    private int backTrace(int[][] cookbooks, boolean[] isCooked, int[] materials, int[][] attribute, int limit, int x, int y) {
        int max = y >= limit ? x : -1;
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
            max = Math.max(max, backTrace(cookbooks, isCooked, materials, attribute, limit, x + attribute[i][0], y + attribute[i][1]));
            // 回溯状态: 回滚烹饪状态, 回滚材料状态
            for (int j = 0; j < cookbooks[i].length; j++) {
                materials[j] += cookbooks[i][j];
            }
            isCooked[i] = false;
        }
        return max;
    }

}
