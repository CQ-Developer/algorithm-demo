package io.huhu.leetcode.n931;

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
    void test(int[][] matrix, int expected) {
        Assertions.assertEquals(expected, code.minFallingPathSum(matrix));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}, 13),
                Arguments.arguments(new int[][]{{-19, 57}, {-40, -5}}, -59));
    }

}