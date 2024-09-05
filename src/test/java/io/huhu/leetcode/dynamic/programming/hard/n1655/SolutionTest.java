package io.huhu.leetcode.dynamic.programming.hard.n1655;

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
        int[] nums = {1, 2, 3, 4}, quantity = {2};
        Assertions.assertFalse(solution.canDistribute(nums, quantity));
    }

    @Test
    void test_2() {
        int[] nums = {1, 2, 3, 3}, quantity = {2};
        Assertions.assertTrue(solution.canDistribute(nums, quantity));
    }

    @Test
    void test_3() {
        int[] nums = {1, 1, 2, 2}, quantity = {2, 2};
        Assertions.assertTrue(solution.canDistribute(nums, quantity));
    }

}
