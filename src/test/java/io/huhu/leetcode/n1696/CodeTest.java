package io.huhu.leetcode.n1696;

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
    void test(int[] nums, int k, int ans) {
        assertEquals(ans, code.maxResult(nums, k));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{1, -1, -2, 4, -7, 3}, 2, 7),
                arguments(new int[]{10, -5, -2, 4, 0, 3}, 3, 17),
                arguments(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2, 0));
    }

}