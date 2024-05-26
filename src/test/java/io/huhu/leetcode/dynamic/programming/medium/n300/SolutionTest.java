package io.huhu.leetcode.dynamic.programming.medium.n300;

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
    void testOne() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Assertions.assertEquals(4, solution.lengthOfLIS(nums));
    }

    @Test
    void testTwo() {
        int[] nums = {0, 1, 0, 3, 2, 3};
        Assertions.assertEquals(4, solution.lengthOfLIS(nums));
    }

    @Test
    void testThree() {
        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        Assertions.assertEquals(1, solution.lengthOfLIS(nums));
    }

    @Test
    void testFour() {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        Assertions.assertEquals(6, solution.lengthOfLIS(nums));
    }

}