package io.huhu.leetcode.dynamic.programming.hard.n689;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int[] actual = solution.maxSumOfThreeSubarrays(nums, 2);
        int[] expect = {0, 3, 5};
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    void test_2() {
        int[] nums = {1, 2, 1, 2, 1, 2, 1, 2, 1};
        int[] actual = solution.maxSumOfThreeSubarrays(nums, 2);
        int[] expect = {0, 2, 4};
        Assertions.assertArrayEquals(expect, actual);
    }

    protected abstract Solution getSolution();

}
