package io.huhu.leetcode.back.trace.n1238;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void circularPermutation1() {
        List<Integer> expected = List.of(3, 1, 0, 2);
        List<Integer> actual = solution.circularPermutation(2, 3);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void circularPermutation2() {
        List<Integer> expected = List.of(2, 0, 1, 3, 7, 5, 4, 6);
        List<Integer> actual = solution.circularPermutation(3, 2);
        Assertions.assertIterableEquals(expected, actual);
    }

}
