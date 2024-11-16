package io.huhu.breadth.first.search.n1162;

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
    @MethodSource("cases")
    void test(int[][] grid, int ans) {
        Assertions.assertEquals(ans, code.maxDistance(grid));
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.arguments(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}, 2),
                Arguments.arguments(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 4));
    }

}