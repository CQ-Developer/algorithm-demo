package io.huhu.leetcode.n978;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Timeout.ThreadMode.SEPARATE_THREAD;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @ParameterizedTest
    @MethodSource("templates")
    @Timeout(value = 1500, unit = MILLISECONDS, threadMode = SEPARATE_THREAD)
    void test(int[] arr, int expected) {
        Assertions.assertEquals(expected, code.maxTurbulenceSize(arr));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}, 5),
                Arguments.arguments(new int[]{4, 8, 12, 16}, 2),
                Arguments.arguments(new int[]{100}, 1));
    }

}