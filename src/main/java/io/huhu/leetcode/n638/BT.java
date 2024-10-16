package io.huhu.leetcode.n638;

import java.util.ArrayList;
import java.util.List;

class BT implements Code {

    @Override
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = needs.size();
        // 移除比单独购买更贵的大礼包
        // 移除超过需求数量的大礼包
        // 移除空的大礼包
        var iterator = special.iterator();
        while (iterator.hasNext()) {
            var sp = iterator.next();
            boolean over = false;
            int p = 0;
            for (int j = 0; j < n; j++) {
                int m = sp.get(j);
                if (m > needs.get(j)) {
                    over = true;
                    break;
                }
                p += m * price.get(j);
            }
            if (over || p == 0 || p <= sp.get(n)) {
                iterator.remove();
            }
        }
        return f(price, special, needs);
    }

    private int f(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int ans = 0;
        // 不购买任何礼包
        for (int i = 0; i < needs.size(); i++) {
            ans += price.get(i) * needs.get(i);
        }
        // 购买礼包
        for (List<Integer> sp : special) {
            List<Integer> _needs = new ArrayList<>();
            for (int i = 0; i < needs.size(); i++) {
                if (sp.get(i) > needs.get(i)) {
                    break;
                }
                _needs.add(needs.get(i) - sp.get(i));
            }
            // 礼包能够购买
            if (_needs.size() == needs.size()) {
                ans = Math.min(ans, f(price, special, _needs) + sp.get(needs.size()));
            }
        }
        return ans;
    }

}
