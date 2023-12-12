package io.huhu.leetcode.back.trace.n2178;

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
        List<Long> expected = List.of(2L, 4L, 6L);
        Assertions.assertIterableEquals(expected, solution.maximumEvenSplit(12));
    }

    @Test
    void case_2() {
        List<Long> expected = List.of();
        Assertions.assertIterableEquals(expected, solution.maximumEvenSplit(7));
    }

    @Test
    void case_3() {
        List<Long> expected = List.of(2L, 4L, 6L, 16L);
        Assertions.assertIterableEquals(expected, solution.maximumEvenSplit(28));
    }

    @Test
    void case_4() {
        List<Long> expected = List.of(2L, 4L, 10L);
        Assertions.assertIterableEquals(expected, solution.maximumEvenSplit(16));
    }

}
