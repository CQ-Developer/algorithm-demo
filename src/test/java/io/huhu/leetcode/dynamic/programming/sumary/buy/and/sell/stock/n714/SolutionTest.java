package io.huhu.leetcode.dynamic.programming.sumary.buy.and.sell.stock.n714;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test1() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        Assertions.assertEquals(8, solution.maxProfit(prices, 2));
    }

    @Test
    void test2() {
        int[] prices = {1, 3, 7, 5, 10, 3};
        Assertions.assertEquals(6, solution.maxProfit(prices, 3));
    }

}