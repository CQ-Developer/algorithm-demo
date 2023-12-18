package io.huhu.leetcode.back.trace.n2597;

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
        int[] nums = {2, 4, 6};
        int k = 2;
        Assertions.assertEquals(4, solution.beautifulSubsets(nums, k));
    }

    @Test
    void case_2() {
        int[] nums = {1};
        int k = 1;
        Assertions.assertEquals(1, solution.beautifulSubsets(nums, k));
    }

    @Test
    void case_3() {
        int[] nums = {9, 5, 7, 10, 6, 2};
        int k = 9;
        Assertions.assertEquals(63, solution.beautifulSubsets(nums, k));
    }

}
