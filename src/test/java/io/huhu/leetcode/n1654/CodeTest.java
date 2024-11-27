package io.huhu.leetcode.n1654;

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
    @MethodSource("params")
    void test(int[] forbidden, int a, int b, int x, int ans) {
        assertEquals(ans, code.minimumJumps(forbidden, a, b, x));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{14, 4, 18, 1, 15}, 3, 15, 9, 3),
                arguments(new int[]{8, 3, 16, 6, 12, 20}, 15, 13, 11, -1),
                arguments(new int[]{1, 6, 2, 14, 5, 17, 4}, 16, 9, 7, 2));
    }

}