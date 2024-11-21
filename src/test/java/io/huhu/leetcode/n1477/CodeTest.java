package io.huhu.leetcode.n1477;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @ParameterizedTest
    @MethodSource("params")
    void test(int[] arr, int target, int ans) {
        assertEquals(ans, code.minSumOfLengths(arr, target));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{3, 2, 2, 4, 3}, 3, 2),
                arguments(new int[]{7, 3, 4, 7}, 7, 2),
                arguments(new int[]{4, 3, 2, 6, 2, 3, 4}, 6, -1));
    }

}