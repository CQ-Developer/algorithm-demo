package io.huhu.leetcode.back.trace.n2044;

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
        int[] nums = {3, 1};
        Assertions.assertEquals(2, solution.countMaxOrSubsets(nums));
    }

    @Test
    void case_2() {
        int[] nums = {2, 2, 2};
        Assertions.assertEquals(7, solution.countMaxOrSubsets(nums));
    }

    @Test
    void case_3() {
        int[] nums = {3, 2, 1, 5};
        Assertions.assertEquals(6, solution.countMaxOrSubsets(nums));
    }

}
