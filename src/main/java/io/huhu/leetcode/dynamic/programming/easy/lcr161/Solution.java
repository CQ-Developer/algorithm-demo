package io.huhu.leetcode.dynamic.programming.easy.lcr161;

/**
 * <a href="https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/description/">连续天数的最高销售记录</a>
 */
class Solution {

    public int maxSales(int[] sales) {
        int max = sales[0];
        for (int i = 1; i < sales.length; i++) {
            sales[i] = Math.max(sales[i], sales[i] + sales[i - 1]);
            max = Math.max(max, sales[i]);
        }
        return max;
    }

}
