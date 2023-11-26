package io.huhu.leetcode.back.trace.n784;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void beforeEach() {
        this.solution = new Solution();
    }

    @Test
    void letterCasePermutation_1() {
        List<String> expected = List.of("a1b2", "a1B2", "A1b2", "A1B2");
        List<String> actual = solution.letterCasePermutation("a1b2");
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertTrue(expected.containsAll(actual));
    }

    @Test
    void letterCasePermutation_2() {
        List<String> expected = List.of("3z4", "3Z4");
        List<String> actual = solution.letterCasePermutation("3z4");
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertTrue(expected.containsAll(actual));
    }

}
