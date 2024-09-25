package io.huhu.leetcode.n5;

import java.util.List;

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
        List<String> expected = List.of("bab", "aba");
        Assertions.assertTrue(expected.contains(code.longestPalindrome("babad")));
    }

    @Test
    void test_2() {
        Assertions.assertEquals("bb", code.longestPalindrome("cbbd"));
    }

    @Test
    void test_3() {
        Assertions.assertEquals("aca", code.longestPalindrome("aacabdkacaa"));
    }

}
