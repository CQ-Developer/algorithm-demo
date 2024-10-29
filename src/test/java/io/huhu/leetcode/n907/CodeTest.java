package io.huhu.leetcode.n907;

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
    void test(int[] arr, int expected) {
        Assertions.assertEquals(expected, code.sumSubarrayMins(arr));
    }

    static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 1, 2, 4}, 17),
                Arguments.arguments(new int[]{11, 81, 94, 43, 3}, 444));
    }

}