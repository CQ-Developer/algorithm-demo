package io.huhu.leetcode.n1911;

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
    void test(int[] nums, long ans) {
        assertEquals(ans, code.maxAlternatingSum(nums));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{4, 2, 5, 3}, 7),
                arguments(new int[]{5, 6, 7, 8}, 8),
                arguments(new int[]{6, 2, 1, 2, 4, 5}, 10));
    }

}