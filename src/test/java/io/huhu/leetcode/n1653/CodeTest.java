package io.huhu.leetcode.n1653;

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
    void test(String s, int ans) {
        assertEquals(ans, code.minimumDeletions(s));
    }

    static Stream<Arguments> params() {
        return Stream.of(arguments("aababbab", 2), arguments("bbaaaaabb", 2));
    }

}