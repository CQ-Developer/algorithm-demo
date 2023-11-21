package io.huhu.leetcode.back.trace.n491;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findSubsequences_1() {
        var expected = List.of(
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
        var expected = List.of(
                List.of(4, 4));
        int[] nums = {4, 4, 3, 2, 1};
        Assertions.assertIterableEquals(expected, solution.findSubsequences(nums));
    }

}
