package io.huhu.leetcode.n808;

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
    void test(int n, double expected) {
        assertEquals(expected, code.soupServings(n));
    }

    static Stream<Arguments> examples() {
        return of(arguments(50, 0.625),
                  arguments(100, 0.71875));
    }

}
