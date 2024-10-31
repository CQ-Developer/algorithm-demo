package io.huhu.leetcode.n926;

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
    @MethodSource("template")
    void test(String s, int expected) {
        Assertions.assertEquals(expected, code.minFlipsMonoIncr(s));
    }

    static Stream<Arguments> template() {
        return Stream.of(
                Arguments.arguments("00110", 1),
                Arguments.arguments("010110", 2),
                Arguments.arguments("00011000", 2));
    }

}