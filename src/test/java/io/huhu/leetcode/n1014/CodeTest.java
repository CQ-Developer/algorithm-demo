package io.huhu.leetcode.n1014;

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
    void test(int[] values, int expected) {
        Assertions.assertEquals(expected, code.maxScoreSightseeingPair(values));
    }

    static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{8, 1, 5, 2, 6}, 11),
                Arguments.arguments(new int[]{1, 2}, 2));
    }

}