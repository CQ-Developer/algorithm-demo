package io.huhu.leetcode.n1277;

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
    @MethodSource("template")
    void test(int[][] matrix, int ans) {
        assertEquals(ans, code.countSquares(matrix));
    }

    static Stream<Arguments> template() {
        return Stream.of(
                arguments(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}, 15),
                arguments(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}, 7));
    }

}