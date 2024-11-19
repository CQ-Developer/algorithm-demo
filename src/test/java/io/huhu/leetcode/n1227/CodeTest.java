package io.huhu.leetcode.n1227;

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
    void test(int n, double ans) {
        Assertions.assertEquals(ans, code.nthPersonGetsNthSeat(n));
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.arguments(1, 1.0),
                Arguments.arguments(2, 0.5));
    }

}