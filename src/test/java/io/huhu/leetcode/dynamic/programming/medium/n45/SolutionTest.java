package io.huhu.leetcode.dynamic.programming.medium.n45;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        int[] nums = {2, 3, 1, 1, 4};
        assertEquals(2, solution.jump(nums));
    }

    @Test
    void test2() {
        int[] nums = {2, 3, 0, 1, 4};
        assertEquals(2, solution.jump(nums));
    }

}