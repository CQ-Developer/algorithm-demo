package io.huhu.leetcode.back.trace.n638;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private List<Integer> needs;
    private List<Integer> price;
    private Map<List<Integer>, Integer> special;
    private int result = Integer.MAX_VALUE;

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
        this.needs = needs;
        this.price = price;
        this.special = initSpecial(special);
        dfs(0);
        return this.result;
    }

    /**
     * 将大礼包转换成 -> 物品数量:价格
     * 同样的大礼包只选取价格最低的
     */
    private Map<List<Integer>, Integer> initSpecial(List<List<Integer>> special) {
        Map<List<Integer>, Integer> result = new HashMap<>();
        for (List<Integer> sp : special) {
            List<Integer> key = new ArrayList<>();
            int i = 0;
            while (i < sp.size() - 1) {
                key.add(sp.get(i++));
            }
            int value = sp.get(i);
            result.compute(key, (k, v) -> v == null ? value : v < value ? v : value);
        }
        return result;
    }

    /**
     * 深度优先遍历
     */
    private void dfs(int cost) {
        if (isFinish() && cost < this.result) {
            this.result = cost;
            return;
        }
        this.special.forEach((list, c) -> {
            if (!canBuySpecial(list)) {
                return;
            }
            buySpecial(list);
            dfs(cost + c);
            backTrace(list);
        });
        buySingle(cost);
    }

    /**
     * 检查是否能买大礼包
     */
    private boolean canBuySpecial(List<Integer> sp) {
        for (int i = 0; i < this.needs.size(); i++) {
            if (this.needs.get(i) - sp.get(i) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 单买一件直到买全所有物品
     */
    private void buySingle(int cost) {
        for (int i = 0; i < this.needs.size(); i++) {
            if (this.needs.get(i) > 0) {
                cost += this.needs.get(i) * this.price.get(i);
            }
        }
        if (cost < result) {
            this.result = cost;
        }
    }

    /**
     * 买一件大礼包
     */
    private void buySpecial(List<Integer> sp) {
        for (int i = 0; i < this.needs.size(); i++) {
            this.needs.set(i, this.needs.get(i) - sp.get(i));
        }
    }

    /**
     * 回溯
     */
    private void backTrace(List<Integer> sp) {
        for (int i = 0; i < this.needs.size(); i++) {
            this.needs.set(i, this.needs.get(i) + sp.get(i));
        }
    }

    /**
     * 检查是否已经购买完所有物品
     */
    private boolean isFinish() {
        for (int need : this.needs) {
            if (need != 0) {
                return false;
            }
        }
        return true;
    }

}
