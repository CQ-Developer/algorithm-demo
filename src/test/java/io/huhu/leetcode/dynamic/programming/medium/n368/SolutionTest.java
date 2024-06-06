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
        List<Integer> actual = solution.largestDivisibleSubset(nums);
        boolean len = actual.size() == 2;
        boolean content = List.of(1, 2).equals(actual) || List.of(1, 3).equals(actual);
        Assertions.assertTrue(len && content);
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 4, 8};
        List<Integer> expected = List.of(1, 2, 4, 8);
        Assertions.assertIterableEquals(expected, solution.largestDivisibleSubset(nums));
    }

}