package io.huhu.leetcode.n77;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void combine_1() {
        var expected = List.of(
                List.of(1, 2),
                List.of(1, 3),
                List.of(1, 4),
                List.of(2, 3),
                List.of(2, 4),
                List.of(3, 4));
        assertIterableEquals(expected, solution.combine(4, 2));
    }

    @Test
    void combine_2() {
        var expected = List.of(List.of(1));
        assertIterableEquals(expected, solution.combine(1, 1));
    }

}
