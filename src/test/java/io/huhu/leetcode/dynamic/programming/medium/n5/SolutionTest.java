package io.huhu.leetcode.dynamic.programming.medium.n5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        String actual = solution.longestPalindrome("babad");
        assertTrue(() -> "bab".equals(actual) || "aba".equals(actual));
    }

    @Test
    void test_2() {
        assertEquals("bb", solution.longestPalindrome("cbbd"));
    }

}
