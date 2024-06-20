package io.huhu.leetcode.classic.combination.sum.n377;

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

    @Test
    void test3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assertions.assertEquals(1023, solution.combinationSum4(nums, 11));
    }

    @Test
    void test4() {
        int[] nums = {3, 1, 2, 4};
        Assertions.assertEquals(8, solution.combinationSum4(nums, 4));
    }

}
