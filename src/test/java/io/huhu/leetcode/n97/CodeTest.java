package io.huhu.leetcode.n97;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @Test
    void test_1() {
        Assertions.assertFalse(code.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    @Test
    void test_2() {
        Assertions.assertFalse(code.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    @Test
    void test_3() {
        Assertions.assertTrue(code.isInterleave("", "", ""));
    }

}
