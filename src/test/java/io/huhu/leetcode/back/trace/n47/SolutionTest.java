package io.huhu.leetcode.back.trace.n47;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void permuteUnique_1() {
        int[] nums = {1, 1, 2};
        var expected = List.of(
                List.of(1, 1, 2),
                List.of(1, 2, 1),
                List.of(2, 1, 1));
        Assertions.assertIterableEquals(expected, solution.permuteUnique(nums));
    }

    @Test
    void permuteUnique_2() {
        int[] nums = {1, 2, 3};
        var expected = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1));
        Assertions.assertIterableEquals(expected, solution.permuteUnique(nums));
    }

    @Test
    void permuteUnique_3() {
        int[] nums = {3, 3, 0, 3};
        var expected = List.of(
                List.of(0, 3, 3, 3),
                List.of(3, 0, 3, 3),
                List.of(3, 3, 0, 3),
                List.of(3, 3, 3, 0));
        Assertions.assertIterableEquals(expected, solution.permuteUnique(nums));
    }

}
