package io.huhu.leetcode.dynamic.programming.easy.n121;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract Solution getSolution();

    @BeforeEach
    void setUp() {
        solution = getSolution();
    }

    @Test
    void maxProfit_1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(5, solution.maxProfit(prices));
    }

    @Test
    void maxProfit_2() {
        int[] prices = {7, 6, 4, 3, 1};
        Assertions.assertEquals(0, solution.maxProfit(prices));
    }

}
