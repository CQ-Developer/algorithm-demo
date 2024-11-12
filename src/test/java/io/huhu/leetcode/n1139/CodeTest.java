package io.huhu.leetcode.n1139;

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
    void test(int[][] grid, int expect) {
        Assertions.assertEquals(expect, code.largest1BorderedSquare(grid));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}, 9),
                Arguments.arguments(new int[][]{{1, 1, 0, 0}}, 1));
    }

}