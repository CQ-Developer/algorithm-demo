package io.huhu.leetcode.n1218;

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
    void test(int[] arr, int difference, int ans) {
        Assertions.assertEquals(ans, code.longestSubsequence(arr, difference));
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4}, 1, 4),
                Arguments.arguments(new int[]{1, 3, 5, 7}, 1, 1),
                Arguments.arguments(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2, 4));
    }

}