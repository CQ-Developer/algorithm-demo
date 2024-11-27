package io.huhu.leetcode.n1639;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @ParameterizedTest
    @MethodSource("params")
    void test(String s, String t, int ans) {
        assertEquals(ans, code.countSubstrings(s, t));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments("aba", "baba", 6),
                arguments("ab", "bb", 3),
                arguments("a", "a", 0),
                arguments("abe", "bbc", 10));
    }

}