package io.huhu.leetcode.bit.manipulation.easy.n2980;

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
    void hasTrailingZeros_1() {
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertTrue(solution.hasTrailingZeros(nums));
    }

    @Test
    void hasTrailingZeros_2() {
        int[] nums = {2, 4, 6, 8, 16};
        Assertions.assertTrue(solution.hasTrailingZeros(nums));
    }

    @Test
    void hasTrailingZeros_3() {
        int[] nums = {1, 3, 5, 7, 9};
        Assertions.assertFalse(solution.hasTrailingZeros(nums));
    }

    @Test
    void hasTrailingZeros_4() {
        int[] nums = {1, 2, 5, 7, 9};
        Assertions.assertFalse(solution.hasTrailingZeros(nums));
    }

}
