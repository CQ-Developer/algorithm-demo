package io.huhu.leetcode.n1191;

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
    void test(int[] arr, int k, int ans) {
        Assertions.assertEquals(ans, code.kConcatenationMaxSum(arr, k));
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2}, 3, 9),
                Arguments.arguments(new int[]{1, -2, 1}, 5, 2),
                Arguments.arguments(new int[]{-1, -2}, 7, 0));
    }

}