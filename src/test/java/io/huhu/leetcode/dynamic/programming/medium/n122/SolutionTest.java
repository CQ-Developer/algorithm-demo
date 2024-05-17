package io.huhu.leetcode.dynamic.programming.medium.n122;

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
    void test_1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(7, solution.maxProfit(prices));
    }

    @Test
    void test_2() {
        int[] prices = {1, 2, 3, 4, 5};
        Assertions.assertEquals(4, solution.maxProfit(prices));
    }

}