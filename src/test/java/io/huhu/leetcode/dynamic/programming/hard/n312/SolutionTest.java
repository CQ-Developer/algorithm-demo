package io.huhu.leetcode.dynamic.programming.hard.n312;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    protected abstract Solution getSolution();

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        int[] nums = {3, 1, 5, 8};
        Assertions.assertEquals(167, solution.maxCoins(nums));
    }

    @Test
    void test_2() {
        int[] nums = {1, 5};
        Assertions.assertEquals(10, solution.maxCoins(nums));
    }

}