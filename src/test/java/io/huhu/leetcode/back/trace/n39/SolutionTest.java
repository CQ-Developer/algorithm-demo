package io.huhu.leetcode.back.trace.n39;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void combinationSum_1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        var expected = List.of(List.of(2, 2, 3), List.of(7));
        Assertions.assertIterableEquals(expected, solution.combinationSum(candidates, target));
    }

    @Test
    void combinationSum_2() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        var expected = List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5));
        Assertions.assertIterableEquals(expected, solution.combinationSum(candidates, target));
    }

    @Test
    void combinationSum_3() {
        int[] candidates = {2};
        int target = 1;
        var expected = List.of();
        Assertions.assertIterableEquals(expected, solution.combinationSum(candidates, target));
    }

}
