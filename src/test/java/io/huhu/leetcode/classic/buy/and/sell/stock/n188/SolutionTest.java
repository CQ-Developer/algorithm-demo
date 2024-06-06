package io.huhu.leetcode.classic.buy.and.sell.stock.n188;

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
        int k = 2;
        int[] prices = {2, 4, 1};
        Assertions.assertEquals(2, solution.maxProfit(k, prices));
    }

    @Test
    void test2() {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        Assertions.assertEquals(7, solution.maxProfit(k, prices));
    }

    @Test
    void test3() {
        int k = 2;
        int[] prices = {2, 4, 1};
        Assertions.assertEquals(2, solution.maxProfit(k, prices));
    }

}