package io.huhu.leetcode.n1186;

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
    @MethodSource("template")
    void test(int[] arr, int ans) {
        Assertions.assertEquals(ans, code.maximumSum(arr));
    }

    static Stream<Arguments> template() {
        return Stream.of(
                Arguments.arguments(new int[]{1, -2, 0, 3}, 4),
                Arguments.arguments(new int[]{1, -2, -2, 3}, 3),
                Arguments.arguments(new int[]{-1, -1, -1, -1}, -1));
    }

}