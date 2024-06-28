package io.huhu.leetcode.dynamic.programming.hard.n32;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract void setup();

    @Test
    void test1() {
        Assertions.assertEquals(2, solution.longestValidParentheses("(()"));
    }

    @Test
    void test2() {
        Assertions.assertEquals(4, solution.longestValidParentheses(")()())"));
    }

    @Test
    void test3() {
        Assertions.assertEquals(0, solution.longestValidParentheses(""));
    }

}
