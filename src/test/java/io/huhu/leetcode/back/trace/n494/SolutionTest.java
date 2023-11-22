package io.huhu.leetcode.back.trace.n494;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findTargetSumWays_1() {
        int[] nums = {1};
        assertEquals(1, solution.findTargetSumWays(nums, 1));
    }

    @Test
    void findTargetSumWays_2() {
        int[] nums = {1, 1, 1, 1, 1};
        assertEquals(5, solution.findTargetSumWays(nums, 3));
    }

    @Test
    void findTargetSumWays_3() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals(125970, solution.findTargetSumWays(nums, 4));
    }

}
