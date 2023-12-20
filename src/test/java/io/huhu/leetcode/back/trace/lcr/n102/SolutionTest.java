package io.huhu.leetcode.back.trace.lcr.n102;

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
    void case_1() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        Assertions.assertEquals(5, solution.findTargetSumWays(nums, target));
    }

    @Test
    void case_2() {
        int[] nums = {1};
        int target = 1;
        Assertions.assertEquals(1, solution.findTargetSumWays(nums, target));
    }

    @Test
    void case_3() {
        int[] nums = {1, 0};
        int target = 1;
        Assertions.assertEquals(2, solution.findTargetSumWays(nums, target));
    }

}
