package io.huhu.leetcode.back.trace.n1774;

/**
 * <a href="https://leetcode.cn/problems/closest-dessert-cost/description/">最接近目标价格的甜点成本</a>
 * <p>你打算做甜点, 现在需要购买配料. 目前共有n中冰激凌基料和m种配料可供选购.
 * 而制作甜点需要遵循以下几条规则:
 * <ul>
 * <li>必须选择一种冰激凌基料
 * <li>可以添加一种或多种配料, 也可以不添加任何配料
 * <li>每种类型的配料最多两份
 * </ul>
 * <p>给你以下三个输入:
 * <ul>
 * <li>baseCosts, 一个长度为n的整数数组, 其中每个baseCosts[i]表示第i种冰激凌基料的价格
 * <li>toppingCosts, 一个长度为m的整数数组, 其中每个toppingCosts[i]表示一份第i种冰激凌配料的价格
 * <li>target, 一个整数, 表示你制作甜点的目标价格
 * </ul>
 * <p>你希望自己做的甜点总成本尽可能接近目标价格target.
 * <p>返回最接近target的甜点成本. 如果有多种方案, 返回成本相对较低的一种.
 */
class Solution {

    private int result = Integer.MAX_VALUE;

    /**
     * <ul>
     * <li>n == baseCosts.length
     * <li>m == toppingCosts.length
     * <li>1 <= n, m <= 10
     * <li>1 <= baseCosts[i], toppingCosts[i] <= 10<sup>4</sup>
     * <li>1 <= target <= 10<sup>4</sup>
     * </ul>
     */
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int baseCost : baseCosts) {
            dfs(toppingCosts, 0, target, baseCost);
        }
        return result;
    }

    /**
     * 深度优先遍历 + 回溯算法
     */
    private void dfs(int[] toppingCosts, int j, int target, int cost) {
        int a = Math.abs(target - result);
        int b = Math.abs(target - cost);
        // 更接近target
        if (b < a) {
            result = cost;
        }
        // 相同取最小
        if (b == a && cost < result) {
            result = cost;
        }
        // 如果已经大于target再加配料则会离target越来越远
        if (cost > target) {
            return;
        }
        for (int i = j; i < toppingCosts.length; i++) {
            dfs(toppingCosts, i + 1, target, cost + toppingCosts[i]);
            dfs(toppingCosts, i + 1, target, cost + toppingCosts[i] * 2);
        }
    }

}
