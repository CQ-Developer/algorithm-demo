package io.huhu.leetcode.dynamic.programming.hard.n1994;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    abstract Solution getSolution();

    @Test
    void test_1() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertEquals(6, solution.numberOfGoodSubsets(nums));
    }

    @Test
    void test_2() {
        int[] nums = {4, 2, 3, 15};
        Assertions.assertEquals(5, solution.numberOfGoodSubsets(nums));
    }

}
