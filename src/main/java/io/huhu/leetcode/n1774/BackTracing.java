package io.huhu.leetcode.n1774;

public class BackTracing implements Code {

    private int res = Integer.MAX_VALUE;

    @Override
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int baseCost : baseCosts) {
            f(toppingCosts, target, 0, baseCost);
        }
        return res;
    }

    private void f(int[] toppingCosts, int target, int i, int cost) {
        int a = Math.abs(target - res), b = Math.abs(target - cost);
        // found a better one
        // if they are same, use the cheaper one
        if (b < a || (b == a && cost < res)) {
            res = cost;
        }
        // if cost is bigger than target, it will get bigger and bigger, so no need continue
        if (cost > target) {
            return;
        }
        for (int j = i; j < toppingCosts.length; j++) {
            f(toppingCosts, target, j + 1, cost + toppingCosts[j]);
            f(toppingCosts, target, j + 1, cost + toppingCosts[j] * 2);
        }
    }

}
