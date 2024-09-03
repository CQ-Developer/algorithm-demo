package io.huhu.leetcode.dynamic.programming.medium.n698;

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
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        Assertions.assertTrue(solution.canPartitionKSubsets(nums, 4));
    }

    @Test
    void test_2() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertFalse(solution.canPartitionKSubsets(nums, 3));
    }

}
