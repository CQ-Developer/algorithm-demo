package io.huhu.leetcode.dynamic.programming.medium.n97;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract void setUp();

    @Test
    void test_1() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        Assertions.assertTrue(solution.isInterleave(s1, s2, s3));
    }

    @Test
    void test_2() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        Assertions.assertFalse(solution.isInterleave(s1, s2, s3));
    }

    @Test
    void test_3() {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        Assertions.assertTrue(solution.isInterleave(s1, s2, s3));
    }

}
