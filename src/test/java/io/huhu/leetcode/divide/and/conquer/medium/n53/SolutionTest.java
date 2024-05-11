package io.huhu.leetcode.divide.and.conquer.medium.n53;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Assertions.assertEquals(6, solution.maxSubArray(nums));
    }

    @Test
    void test_2() {
        int[] nums = {1};
        Assertions.assertEquals(1, solution.maxSubArray(nums));
    }

    @Test
    void test_3() {
        int[] nums = {5, 4, -1, 7, 8};
        Assertions.assertEquals(23, solution.maxSubArray(nums));
    }

}
