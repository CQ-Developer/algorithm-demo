package io.huhu.leetcode.back.trace.lcr.n080;

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
        List<List<Integer>> actual = solution.combine(4, 2);
        List<List<Integer>> expected = List.of(List.of(2, 4), List.of(3, 4), List.of(2, 3), List.of(1, 2), List.of(1, 3), List.of(1, 4));
        Assertions.assertEquals(expected.size(), actual.size());
        for (List<Integer> combine : expected) {
            Assertions.assertTrue(actual.contains(combine));
        }
    }

    @Test
    void case_2() {
        List<List<Integer>> actual = solution.combine(1, 1);
        List<List<Integer>> expected = List.of(List.of(1));
        Assertions.assertEquals(expected.size(), actual.size());
        for (List<Integer> combine : expected) {
            Assertions.assertTrue(actual.contains(combine));
        }
    }

}
