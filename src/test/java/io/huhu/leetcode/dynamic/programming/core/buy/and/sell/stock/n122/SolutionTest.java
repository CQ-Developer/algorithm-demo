package io.huhu.leetcode.dynamic.programming.core.buy.and.sell.stock.n122;

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
        int[] prices = {7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(7, solution.maxProfit(prices));
    }

    @Test
    void test2() {
        int[] prices = {1, 2, 3, 4, 5};
        Assertions.assertEquals(4, solution.maxProfit(prices));
    }

    @Test
    void test3() {
        int[] prices = {7, 6, 4, 3, 1};
        Assertions.assertEquals(0, solution.maxProfit(prices));
    }

}
