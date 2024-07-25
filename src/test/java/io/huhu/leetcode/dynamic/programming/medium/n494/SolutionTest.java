package io.huhu.leetcode.dynamic.programming.medium.n494;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    protected abstract Solution getSolution();

    @Test
    void test_1() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        Assertions.assertEquals(5, solution.findTargetSumWays(nums, target));
    }

    @Test
    void test_2() {
        int[] nums = {1};
        int target = 1;
        Assertions.assertEquals(1, solution.findTargetSumWays(nums, target));
    }

}
