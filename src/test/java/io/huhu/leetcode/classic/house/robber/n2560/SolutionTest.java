package io.huhu.leetcode.classic.house.robber.n2560;

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
        int[] nums = {2, 3, 5, 9};
        int k = 2;
        Assertions.assertEquals(5, solution.minCapability(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {2, 7, 9, 3, 1};
        int k = 2;
        Assertions.assertEquals(2, solution.minCapability(nums, k));
    }

}