package io.huhu.leetcode.n1039;

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
    void test(int[] values, int expected) {
        Assertions.assertEquals(expected, code.minScoreTriangulation(values));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3}, 6),
                Arguments.arguments(new int[]{3, 7, 4, 5}, 144),
                Arguments.arguments(new int[]{1, 3, 1, 4, 1, 5}, 13));
    }

}