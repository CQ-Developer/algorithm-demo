package io.huhu.leetcode.dynamic.programming.hard.n123;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract Solution getSolution();

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        Assertions.assertEquals(6, solution.maxProfit(prices));
    }

    @Test
    void test_2() {
        int[] prices = {1, 2, 3, 4, 5};
        Assertions.assertEquals(4, solution.maxProfit(prices));
    }

    @Test
    void test_3() {
        int[] prices = {7, 6, 4, 3, 1};
        Assertions.assertEquals(0, solution.maxProfit(prices));
    }

}
