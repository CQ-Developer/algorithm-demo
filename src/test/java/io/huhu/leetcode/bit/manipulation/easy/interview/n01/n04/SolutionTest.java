package io.huhu.leetcode.bit.manipulation.easy.interview.n01.n04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @ValueSource(strings = {"tactcoa", "aa", "a"})
    void canPermutePalindrome_true(String s) {
        Assertions.assertTrue(solution.canPermutePalindrome(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"code", "as", "abcd"})
    void canPermutePalindrome_false(String s) {
        Assertions.assertFalse(solution.canPermutePalindrome(s));
    }

}
