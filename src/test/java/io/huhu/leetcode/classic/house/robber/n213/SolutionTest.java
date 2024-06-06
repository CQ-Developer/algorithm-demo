package io.huhu.leetcode.classic.house.robber.n213;

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
    void test1() {
        int[] nums = {2, 3, 2};
        Assertions.assertEquals(3, solution.rob(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 3, 1};
        Assertions.assertEquals(4, solution.rob(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3};
        Assertions.assertEquals(3, solution.rob(nums));
    }

}