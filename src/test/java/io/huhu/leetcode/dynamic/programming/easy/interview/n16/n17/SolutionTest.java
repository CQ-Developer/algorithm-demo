package io.huhu.leetcode.dynamic.programming.easy.interview.n16.n17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, solution.maxSubArray(nums));
    }

    @Test
    void test_2() {
        int[] nums = {-1, -2};
        assertEquals(-1, solution.maxSubArray(nums));
    }

}
