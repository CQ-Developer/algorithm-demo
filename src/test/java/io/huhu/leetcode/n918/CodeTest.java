package io.huhu.leetcode.n918;

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
    @MethodSource("examples")
    void test(int[] nums, int expected) {
        Assertions.assertEquals(expected, code.maxSubarraySumCircular(nums));
    }

    static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{1, -2, 3, -2}, 3),
                Arguments.arguments(new int[]{5, -3, 5}, 10),
                Arguments.arguments(new int[]{-3, -2, -3}, -2));
    }

}