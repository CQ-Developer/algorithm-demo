package io.huhu.leetcode.n838;

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
    @MethodSource("examples")
    void test(String dominoes, String expected) {
        Assertions.assertEquals(expected, code.pushDominoes(dominoes));
    }

    static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments("RR.L", "RR.L"),
                Arguments.arguments(".L.R...LR..L..", "LL.RR.LLRRLL.."));
    }

}