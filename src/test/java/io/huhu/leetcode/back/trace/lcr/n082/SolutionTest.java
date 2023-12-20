package io.huhu.leetcode.back.trace.lcr.n082;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> actual = solution.combinationSum2(candidates, target);
        List<List<Integer>> expected = List.of(List.of(1, 1, 6), List.of(1, 2, 5), List.of(1, 7), List.of(2, 6));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_2() {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> actual = solution.combinationSum2(candidates, target);
        List<List<Integer>> expected = List.of(List.of(1, 2, 2), List.of(5));
        Assertions.assertIterableEquals(expected, actual);
    }

}
