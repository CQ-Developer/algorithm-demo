package io.huhu.leetcode.dynamic.programming.hard.n730;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract Solution getSolution();

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        Assertions.assertEquals(6, solution.countPalindromicSubsequences("bccb"));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(104860361, solution.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }

}
