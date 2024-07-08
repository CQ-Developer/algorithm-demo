package io.huhu.leetcode.dynamic.programming.hard.n87;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract void setup();

    @Test
    void test1() {
        Assertions.assertTrue(solution.isScramble("great", "rgeat"));
    }

    @Test
    void test2() {
        Assertions.assertFalse(solution.isScramble("abcde", "caebd"));
    }

    @Test
    void test3() {
        Assertions.assertTrue(solution.isScramble("a", "a"));
    }

}
