package io.huhu.leetcode.dynamic.programming.sumary.buy.and.sell.stock.n309;

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
        int[] prices = {1, 2, 3, 0, 2};
        Assertions.assertEquals(3, solution.maxProfit(prices));
    }

    @Test
    void test2() {
        int[] prices = {1};
        Assertions.assertEquals(0, solution.maxProfit(prices));
    }

}