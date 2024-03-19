package io.huhu.leetcode.dynamic.programming.easy.interview.n17.n16;

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
        int[] nums = {1, 2, 3, 1};
        assertEquals(4, solution.massage(nums));
    }

    @Test
    void test_2() {
        int[] nums = {2, 7, 9, 3, 1};
        assertEquals(12, solution.massage(nums));
    }

    @Test
    void test_3() {
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        assertEquals(12, solution.massage(nums));
    }

}
