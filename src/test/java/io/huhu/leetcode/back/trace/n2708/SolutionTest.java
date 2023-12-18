package io.huhu.leetcode.back.trace.n2708;

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
        int[] nums = {3, -1, -5, 2, 5, -9};
        Assertions.assertEquals(1350, solution.maxStrength(nums));
    }

    @Test
    void case_2() {
        int[] nums = {-4, -5, -4};
        Assertions.assertEquals(20, solution.maxStrength(nums));
    }

}
