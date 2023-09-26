package io.huhu.leetcode.n53;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void maxSubArray_1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, solution.maxSubArray(nums));
    }

    @Test
    void maxSubArray_2() {
        int[] nums = {1};
        assertEquals(1, solution.maxSubArray(nums));
    }

    @Test
    void maxSubArray_3() {
        int[] nums = {5, 4, -1, 7, 8};
        assertEquals(23, solution.maxSubArray(nums));
    }

}
