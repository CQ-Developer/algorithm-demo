package io.huhu.leetcode.dynamic.programming.medium.n1143;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract void setup();

    @Test
    void test1() {
        Assertions.assertEquals(3, solution.longestCommonSubsequence("abcde", "ace"));
    }

    @Test
    void test2() {
        Assertions.assertEquals(3, solution.longestCommonSubsequence("abc", "abc"));
    }

    @Test
    void test3() {
        Assertions.assertEquals(0, solution.longestCommonSubsequence("abc", "def"));
    }

}
