package io.huhu.leetcode.dynamic.programming.medium.n377;

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
        int[] nums = {1, 2, 3};
        Assertions.assertEquals(7, solution.combinationSum4(nums, 4));
    }

    @Test
    void test2() {
        int[] nums = {9};
        Assertions.assertEquals(0, solution.combinationSum4(nums, 3));
    }

}
