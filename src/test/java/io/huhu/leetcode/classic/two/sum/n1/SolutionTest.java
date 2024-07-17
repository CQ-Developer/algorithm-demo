package io.huhu.leetcode.classic.two.sum.n1;

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
        int[] nums = {2, 7, 11, 15};
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution.twoSum(nums, 9));
    }

    @Test
    void test_2() {
        int[] nums = {3, 2, 4};
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution.twoSum(nums, 6));
    }

    @Test
    void test_3() {
        int[] nums = {3, 3};
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution.twoSum(nums, 6));
    }

}
