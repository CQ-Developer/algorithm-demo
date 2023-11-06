package io.huhu.leetcode.back.trace.n40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void combinationSum2_1() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> expected = List.of(List.of(1, 1, 6), List.of(1, 2, 5), List.of(1, 7), List.of(2, 6));
        Assertions.assertIterableEquals(expected, solution.combinationSum2(candidates, target));
    }

    @Test
    void combinationSum2_2() {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> expected = List.of(List.of(1, 2, 2), List.of(5));
        Assertions.assertIterableEquals(expected, solution.combinationSum2(candidates, target));
    }

}
