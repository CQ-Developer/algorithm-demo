package io.huhu.leetcode.back.trace.n46;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void permute_1() {
        int[] nums = {1, 2, 3};
        var expected = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1));
        Assertions.assertIterableEquals(expected, solution.permute(nums));
    }

    @Test
    void permute_2() {
        int[] nums = {0, 1};
        var expected = List.of(List.of(0, 1), List.of(1, 0));
        Assertions.assertIterableEquals(expected, solution.permute(nums));
    }

    @Test
    void permute_3() {
        int[] nums = {1};
        var expected = List.of(List.of(1));
        Assertions.assertIterableEquals(expected, solution.permute(nums));
    }

}
