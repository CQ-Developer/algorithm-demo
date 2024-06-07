package io.huhu.leetcode.dynamic.programming.medium.n368;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test1() {
        int[] nums = {1, 2, 3};
        List<Integer> expected = List.of(1, 2);
        Assertions.assertIterableEquals(expected, solution.largestDivisibleSubset(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 4, 8};
        List<Integer> expected = List.of(1, 2, 4, 8);
        Assertions.assertIterableEquals(expected, solution.largestDivisibleSubset(nums));
    }

    @Test
    void test3() {
        int[] nums = {1};
        Assertions.assertIterableEquals(List.of(1), solution.largestDivisibleSubset(nums));
    }

    @Test
    void test4() {
        int[] nums = {3, 4, 16, 8};
        List<Integer> expected = List.of(4, 8, 16);
        Assertions.assertIterableEquals(expected, solution.largestDivisibleSubset(nums));
    }

    @Test
    void test5() {
        int[] nums = {343, 49, 8, 4, 2, 1};
        List<Integer> expected = List.of(1, 2, 4, 8);
        Assertions.assertIterableEquals(expected, solution.largestDivisibleSubset(nums));
    }

}
