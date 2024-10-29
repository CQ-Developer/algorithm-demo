package io.huhu.leetcode.n898;

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
        Assertions.assertEquals(expected, code.subarrayBitwiseORs(arr));
    }

    static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{0}, 1),
                Arguments.arguments(new int[]{1, 1, 2}, 3),
                Arguments.arguments(new int[]{1, 2, 4}, 6));
    }

}