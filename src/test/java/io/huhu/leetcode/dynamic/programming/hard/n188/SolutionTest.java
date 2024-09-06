package io.huhu.leetcode.dynamic.programming.hard.n188;

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
        int[] prices = {2, 4, 1};
        Assertions.assertEquals(2, solution.maxProfit(2, prices));
    }

    @Test
    void test_2() {
        int[] prices = {3, 2, 6, 5, 0, 3};
        Assertions.assertEquals(7, solution.maxProfit(2, prices));
    }

    @Test
    void test_3() {
        int[] prices = {6, 1, 3, 2, 4, 7};
        Assertions.assertEquals(7, solution.maxProfit(2, prices));
    }

}
