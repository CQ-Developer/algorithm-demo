package io.huhu.leetcode.greedy.n179;

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
        int[] nums = {10, 2};
        Assertions.assertEquals("210", solution.largestNumber(nums));
    }

    @Test
    void test_2() {
        int[] nums = {3, 30, 34, 5, 9};
        Assertions.assertEquals("9534330", solution.largestNumber(nums));
    }

    @Test
    void test_3() {
        int[] nums = {0, 0};
        Assertions.assertEquals("0", solution.largestNumber(nums));
    }

}
