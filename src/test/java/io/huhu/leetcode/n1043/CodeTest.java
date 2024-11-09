package io.huhu.leetcode.n1043;

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
    void test(int[] arr, int k, int expected) {
        Assertions.assertEquals(expected, code.maxSumAfterPartitioning(arr, k));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 15, 7, 9, 2, 5, 10}, 3, 84),
                Arguments.arguments(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4, 83),
                Arguments.arguments(new int[]{1}, 1, 1));
    }

}