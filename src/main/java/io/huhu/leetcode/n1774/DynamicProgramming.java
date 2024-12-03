package io.huhu.leetcode.n1774;

class DynamicProgramming implements Code {

    @Override
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int ans = Integer.MAX_VALUE;
        boolean[] f = new boolean[target + 5];
        for (int baseCost : baseCosts) {
            if (baseCost <= target) {
                f[baseCost] = true;
            } else {
                ans = Math.min(ans, baseCost);
            }
        }
        for (int toppingCost : toppingCosts) {
            // each topping can be used twice
            for (int count = 0; count < 2; count++) {
                for (int cost = target; cost >= 0; cost--) {
                    if (f[cost] && cost + toppingCost > target) {
                        ans = Math.min(ans, cost + toppingCost);
                    }
                    if (cost > toppingCost) {
                        f[cost] |= f[cost - toppingCost];
                    }
                }
            }
        }
        for (int dif = 0; dif <= ans - target && dif < target; dif++) {
            if (f[target - dif]) {
                return target - dif;
            }
        }
        return ans;
    }

}
