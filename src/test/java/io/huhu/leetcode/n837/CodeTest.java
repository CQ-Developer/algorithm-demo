package io.huhu.leetcode.n837;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static java.math.RoundingMode.HALF_UP;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @ParameterizedTest
    @MethodSource("examples")
    void test(int n, int k, int maxPts, double expected) {
        double actual = BigDecimal.valueOf(code.new21Game(n, k, maxPts))
                .setScale(5, HALF_UP)
                .doubleValue();
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(10, 1, 10, 1.0),
                Arguments.arguments(6, 1, 10, 0.6),
                Arguments.arguments(21, 17, 10, 0.73278));
    }

}