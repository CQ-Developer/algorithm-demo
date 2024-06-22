package io.huhu.leetcode.dynamic.programming.medium.n416;

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
    void test1() {
        int[] nums = {1, 5, 11, 5};
        Assertions.assertTrue(solution.canPartition(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 3, 5};
        Assertions.assertFalse(solution.canPartition(nums));
    }

}