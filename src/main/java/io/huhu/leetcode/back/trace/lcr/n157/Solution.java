package io.huhu.leetcode.back.trace.lcr.n157;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/description/">套餐内商品的排列顺序</a>
 * <p>某商店内将用于组成套餐的商品记作字符串goods, 其中goods[i]表示对应商品. 请返回该套餐内所含商品的全部排列方式.
 * <p>返回结果无顺序要求, 但不能含有重复的元素.
 * <p>提示:
 * <li>1 <= goods.length <= 8
 */
class Solution {

    public String[] goodsOrder(String goods) {
        List<String> res = new ArrayList<>();
        char[] chars = goods.toCharArray();
        Arrays.sort(chars);
        backTracing(chars, new boolean[goods.length()], new StringBuilder(), res);
        return res.toArray(new String[0]);
    }

    private void backTracing(char[] goods, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == goods.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < goods.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && goods[i - 1] == goods[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sb.append(goods[i]);
            backTracing(goods, used, sb, res);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
