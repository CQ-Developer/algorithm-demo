package io.huhu.leetcode.dynamic.programming.medium.n918;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract void setup();

    @Test
    void test1() {
        int[] nums = {1, -2, 3, -2};
        Assertions.assertEquals(3, solution.maxSubarraySumCircular(nums));
    }

    @Test
    void test2() {
        int[] nums = {5, -3, 5};
        Assertions.assertEquals(10, solution.maxSubarraySumCircular(nums));
    }

    @Test
    void test3() {
        int[] nums = {-3, -2, -3};
        Assertions.assertEquals(-2, solution.maxSubarraySumCircular(nums));
    }

}
