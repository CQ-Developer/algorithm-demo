package io.huhu.leetcode.dynamic.programming.medium.n2560;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SolutionTest {

    static Solution solution;

    @BeforeAll
    static void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        int[] nums = {2, 3, 5, 9};
        Assertions.assertEquals(5, solution.minCapability(nums, 2));
    }

    @Test
    void test_2() {
        int[] nums = {2, 7, 9, 3, 1};
        Assertions.assertEquals(2, solution.minCapability(nums, 2));
    }

}
