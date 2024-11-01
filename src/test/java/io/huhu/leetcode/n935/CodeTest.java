package io.huhu.leetcode.n935;

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
    void test(int n, int expected) {
        Assertions.assertEquals(expected, code.knightDialer(n));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments(1, 10),
                Arguments.arguments(2, 20),
                Arguments.arguments(3131, 136006598));
    }

}