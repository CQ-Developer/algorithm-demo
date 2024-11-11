package io.huhu.leetcode.n1049;

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
    void test(int[] stones, int expected) {
        Assertions.assertEquals(expected, code.lastStoneWeightII(stones));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 7, 4, 1, 8, 1}, 1),
                Arguments.arguments(new int[]{31, 26, 33, 21, 40}, 5));
    }

}