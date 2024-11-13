package io.huhu.leetcode.n1143;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @ParameterizedTest
    @MethodSource("templates")
    void test(String s1, String s2, int ans) {
        Assertions.assertEquals(ans, code.longestCommonSubsequence(s1, s2));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments("abcde", "ace", 3),
                Arguments.arguments("abc", "abc", 3),
                Arguments.arguments("abc", "def", 0));
    }

}