package io.huhu.leetcode.back.trace.n131;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void partition_1() {
        var expected = List.of(
                List.of("a", "a", "b"),
                List.of("aa", "b"));
        Assertions.assertIterableEquals(expected, solution.partition("aab"));
    }

    @Test
    void partition_2() {
        var expected = List.of(List.of("a"));
        Assertions.assertIterableEquals(expected, solution.partition("a"));
    }

}
