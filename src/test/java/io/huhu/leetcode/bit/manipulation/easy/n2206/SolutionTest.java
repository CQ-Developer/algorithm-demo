package io.huhu.leetcode.bit.manipulation.easy.n2206;

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
    void divideArray_1() {
        int[] nums = {3, 2, 3, 2, 2, 2};
        Assertions.assertTrue(solution.divideArray(nums));
    }

    @Test
    void divideArray_2() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertFalse(solution.divideArray(nums));
    }

    @Test
    void divideArray_3() {
        int[] nums = {9, 9, 19, 10, 9, 12, 2, 12, 3, 3, 11, 5, 8, 4, 13, 6, 2, 11, 9, 19, 11, 15, 9, 17, 15, 12, 5, 14, 12, 16, 18, 16, 10, 3, 8, 9, 16, 20, 2, 4, 16, 12, 11, 14, 20, 16, 2, 18, 17, 20, 3, 13, 16, 17, 1, 1, 11, 20, 20, 4};
        Assertions.assertFalse(solution.divideArray(nums));
    }

}
