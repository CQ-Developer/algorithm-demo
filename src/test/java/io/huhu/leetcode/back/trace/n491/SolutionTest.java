package io.huhu.leetcode.back.trace.n491;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findSubsequences_1() {
        List<List<Integer>> expected = List.of(
                List.of(4, 6),
                List.of(4, 6, 7),
                List.of(4, 6, 7, 7),
                List.of(4, 7),
                List.of(4, 7, 7),
                List.of(6, 7),
                List.of(6, 7, 7),
                List.of(7, 7));
        int[] nums = {4, 6, 7, 7};
        Assertions.assertIterableEquals(expected, solution.findSubsequences(nums));
    }

    @Test
    void findSubsequences_2() {
        List<List<Integer>> expected = List.of(
                List.of(4, 4));
        int[] nums = {4, 4, 3, 2, 1};
        Assertions.assertIterableEquals(expected, solution.findSubsequences(nums));
    }

    @Test
    void findSubsequences_3() {
        List<List<Integer>> expected = List.of(
                List.of(-100, -100),
                List.of(-100, -100, 0),
                List.of(-100, -100, 0, 0),
                List.of(-100, -100, 0, 0, 0),
                List.of(-100, -100, 0, 0, 0, 100),
                List.of(-100, -100, 0, 0, 0, 100, 100),
                List.of(-100, -100, 0, 0, 0, 0),
                List.of(-100, -100, 0, 0, 0, 0, 0),
                List.of(-100, -100, 0, 0, 100),
                List.of(-100, -100, 0, 0, 100, 100),
                List.of(-100, -100, 0, 100),
                List.of(-100, -100, 0, 100, 100),
                List.of(-100, -100, 100),
                List.of(-100, -100, 100, 100),
                List.of(-100, 0),
                List.of(-100, 0, 0),
                List.of(-100, 0, 0, 0),
                List.of(-100, 0, 0, 0, 100),
                List.of(-100, 0, 0, 0, 100, 100),
                List.of(-100, 0, 0, 0, 0),
                List.of(-100, 0, 0, 0, 0, 0),
                List.of(-100, 0, 0, 100),
                List.of(-100, 0, 0, 100, 100),
                List.of(-100, 0, 100),
                List.of(-100, 0, 100, 100),
                List.of(-100, 100),
                List.of(-100, 100, 100),
                List.of(0, 0),
                List.of(0, 0, 0),
                List.of(0, 0, 0, 100),
                List.of(0, 0, 0, 100, 100),
                List.of(0, 0, 0, 0),
                List.of(0, 0, 0, 0, 0),
                List.of(0, 0, 100),
                List.of(0, 0, 100, 100),
                List.of(0, 100),
                List.of(0, 100, 100),
                List.of(100, 100));
        int[] nums = {-100, -100, 0, 0, 0, 100, 100, 0, 0};
        Assertions.assertIterableEquals(expected, solution.findSubsequences(nums));
    }

}
