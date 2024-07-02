package io.huhu.leetcode.dynamic.programming.medium.n516;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract void setup();

    @Test
    void test1() {
        Assertions.assertEquals(4, solution.longestPalindromeSubseq("bbbab"));
    }

    @Test
    void test2() {
        Assertions.assertEquals(2, solution.longestPalindromeSubseq("cbbd"));
    }

}
