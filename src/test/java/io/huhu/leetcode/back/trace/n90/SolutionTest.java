package io.huhu.leetcode.back.trace.n90;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void subsetsWithDup_1() {
        int[] nums = {1, 2, 2};
        var expected = List.of(
                List.of(),
                List.of(1),
                List.of(2),
                List.of(1, 2),
                List.of(2, 2),
                List.of(1, 2, 2));
        Assertions.assertIterableEquals(expected, solution.subsetsWithDup(nums));
    }

    @Test
    void subsetsWithDup_2() {
        int[] nums = {1, 2, 2, 3};
        var expected = List.of(
                List.of(),
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(1, 2),
                List.of(1, 3),
                List.of(2, 2),
                List.of(2, 3),
                List.of(1, 2, 2),
                List.of(1, 2, 3),
                List.of(2, 2, 3),
                List.of(1, 2, 2, 3));
        Assertions.assertIterableEquals(expected, solution.subsetsWithDup(nums));
    }

    @Test
    void subsetsWithDup_3() {
        int[] nums = {0};
        var expected = List.of(List.of(), List.of(0));
        Assertions.assertIterableEquals(expected, solution.subsetsWithDup(nums));
    }

}
