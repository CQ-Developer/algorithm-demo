package io.huhu.leetcode.dynamic.programming.medium.n376;

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
        int[] nums = {1, 7, 4, 9, 2, 5};
        Assertions.assertEquals(6, solution.wiggleMaxLength(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        Assertions.assertEquals(7, solution.wiggleMaxLength(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertEquals(2, solution.wiggleMaxLength(nums));
    }

    @Test
    void test4() {
        int[] nums = {1};
        Assertions.assertEquals(1, solution.wiggleMaxLength(nums));
    }

    @Test
    void test5() {
        int[] nums = {1, 2};
        Assertions.assertEquals(2, solution.wiggleMaxLength(nums));
    }

}
