package io.huhu.leetcode.n799;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

abstract class CodeTest {

    Code code;

    abstract Code code();

    @BeforeEach
    void setup() {
        code = code();
    }

    @ParameterizedTest
    @MethodSource("examples")
    void test(int poured, int query_row, int query_glass, double expected) {
        assertEquals(expected, code.champagneTower(poured, query_row, query_glass));
    }

    static Stream<Arguments> examples() {
        return of(arguments(1, 1, 1, 0.0),
                  arguments(2, 1, 1, 0.5),
                  arguments(100000009, 33, 17, 1.0));
    }

}