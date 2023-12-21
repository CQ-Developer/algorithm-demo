package io.huhu.leetcode.back.trace.interview.questions.n08.n07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        String[] actual = solution.permutation("qwe");
        String[] expected = {"qwe", "qew", "wqe", "weq", "ewq", "eqw"};
        Arrays.sort(actual, CharSequence::compare);
        Arrays.sort(expected, CharSequence::compare);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void case_2() {
        String[] actual = solution.permutation("ab");
        String[] expected = {"ab", "ba"};
        Arrays.sort(actual, CharSequence::compare);
        Arrays.sort(expected, CharSequence::compare);
        Assertions.assertArrayEquals(expected, actual);
    }

}
