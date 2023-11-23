package io.huhu.leetcode.back.trace.n638;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/shopping-offers/description/">638.大礼包</a>
 * 在LeetCode商店中, 有n件在售的物品. 每件物品都有对应的价格. 然而, 也有一些大礼包, 每个大礼包以优惠的价格捆绑销售一组物品.
 * 给你一个整数数组price表示物品价格, 其中price[i]是第i件物品的价格. 另有一个整数数组needs表示购物清单, 其中need[i]是需要购买第i件物品的数量.
 * 还有一个数组special表示大礼包, special[i]的长度为n+1, 其中special[i][j]表示第i个大礼包中内含第j件物品的数量, 且special[i][n]为第i个大礼包的价格.
 * 返回确切满足购物清单所需花费的最低价格, 你可以充分利用大礼包的优惠活动. 你不能购买超出购物清单指定数量的物品, 即使那样会降低整体价格. 任意大礼包可无限次购买.
 * n == price.length
 * n == needs.length
 * 1 <= n <= 6
 * 0 <= price[i] <= 10
 * 0 <= needs[i] <= 10
 * 1 <= special.length <= 100
 * special[i].length == n + 1
 * 0 <= special[i][j] <= 50
 */
class Solution {

    List<List<Integer>> specials = new ArrayList<>();
    List<Integer> needs = new ArrayList<>();
    int result = Integer.MAX_VALUE;

    /**
     * n == price.length
     * n == needs.length
     * 1 <= n <= 6
     * 0 <= price[i] <= 10
     * 0 <= needs[i] <= 10
     * 1 <= special.length <= 100
     * special[i].length == n + 1
     * 0 <= special[i][j] <= 50
     *
     * @param price   物品价格
     *                price[i]表示第i件物品的价格
     * @param special 大礼包
     *                special[i][j]表示第i个大礼包中第j件物品的数量.
     *                special[i][n]表示第i个大礼包的价格
     * @param needs   购物清单
     *                needs[i]表示需要购买第i件物品的数量
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = needs.size();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(0);
            }
            list.set(i, 1);
            list.add(price.get(i));
            this.specials.add(list);
        }
        this.specials.addAll(special);
        this.needs.addAll(needs);
        dfs(0);
        return result;
    }

    private void dfs(int cost) {
        if (isFinish(needs) && cost < result) {
            System.out.println(cost);
            result = cost;
        }
        for (List<Integer> special : specials) {
            int n = needs.size();
            if (!canBuy(needs, special, n)) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                needs.set(j, needs.get(j) - special.get(j));
            }
            dfs(cost + special.get(n));
            for (int j = 0; j < n; j++) {
                needs.set(j, needs.get(j) + special.get(j));
            }
        }
    }

    private boolean isFinish(List<Integer> needs) {
        for (int need : needs) {
            if (need != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean canBuy(List<Integer> needs, List<Integer> special, int n) {
        for (int i = 0; i < n; i++) {
            if (needs.get(i) - special.get(i) < 0) {
                return false;
            }
        }
        return true;
    }

}
